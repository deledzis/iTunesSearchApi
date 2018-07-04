package com.forasoft.albumslib.client.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.forasoft.albumslib.R;
import com.forasoft.albumslib.client.adapter.TracksAdapter;
import com.forasoft.albumslib.client.model.Album;
import com.forasoft.albumslib.client.model.Track;
import com.forasoft.albumslib.client.util.App;
import com.forasoft.albumslib.client.util.InternetChecker;
import com.forasoft.albumslib.server.request.ApiRequestCallback;
import com.forasoft.albumslib.server.request.Caller;
import com.forasoft.albumslib.server.response.model.track.TrackPOJO;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.forasoft.albumslib.client.util.App.*;

public class AlbumDetailActivity extends AppCompatActivity {
    public static final String ITUNES_SEARCH_API_BASE_URL = "https://itunes.apple.com/";

    private AlbumDetailActivity mContext;

    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ImageView mExpandedCover;
    private AppCompatButton mOpenITunesInBrowser;

    private TextView mArtist;
    private TextView mYear;
    private TextView mPrice;
    private TextView mGenre;
    private TextView mTracksCount;

    private RecyclerView mTracksRecyclerView;
    private TracksAdapter mTracksAdapter;
    private List<Track> mTrackList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        mContext = this;

        mAppBarLayout = findViewById(R.id.album_detail_appbar);
        mCollapsingToolbarLayout = findViewById(R.id.album_detail_collapsing_toolbar);
        mToolbar = findViewById(R.id.album_detail_toolbar);
        mExpandedCover = findViewById(R.id.album_detail_expanded_cover);
        mOpenITunesInBrowser = findViewById(R.id.album_detail_see_on_site_button);

        mArtist = findViewById(R.id.album_detail_artist);
        mYear = findViewById(R.id.album_detail_year);
        mPrice = findViewById(R.id.album_detail_price);
        mGenre = findViewById(R.id.album_detail_genre);
        mTracksCount = findViewById(R.id.album_detail_tracks_count);

        mTracksRecyclerView = findViewById(R.id.album_detail_tracks_list);

        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTracksRecyclerView.setNestedScrollingEnabled(false);
        } else {
            ViewCompat.setNestedScrollingEnabled(mTracksRecyclerView, false);
        }
        final Album album = getIntent().getParcelableExtra(ALBUM_DATA_TAG);

        setSupportActionBar(mToolbar);
        mCollapsingToolbarLayout.setTitle(album.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new InternetChecker(new InternetChecker.Consumer() {
            @Override
            public void accept(Boolean internet) {
                if (internet) {
                    Picasso.get()
                            .load(album.getCoverPath())
                            .placeholder(R.drawable.ic_library_music_pink_72dp)
                            .networkPolicy(NetworkPolicy.OFFLINE)
                            .into(mExpandedCover, new Callback() {
                                @Override
                                public void onSuccess() {
                                    Log.d(ALBUM_DETAIL_TAG + SUCCESS_TAG, "Picasso found image in memory");
                                }

                                @Override
                                public void onError(Exception e) {
                                    //Try again online if cache failed
                                    Picasso.get()
                                            .load(album.getCoverPath())
                                            .error(R.drawable.ic_error_24dp)
                                            .resize(300, 300)
                                            .into(mExpandedCover, new Callback() {
                                                @Override
                                                public void onSuccess() {
                                                    Log.d(ALBUM_DETAIL_TAG + SUCCESS_TAG, "Picasso downloaded image online");
                                                }

                                                @Override
                                                public void onError(Exception e) {
                                                    Log.e("Picasso","Could not fetch image");
                                                }
                                            });
                                }

                            });
                }
                else {
                    Toast.makeText(mContext,
                            getResources().getString(R.string.no_available_internet_connection),
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        mOpenITunesInBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(album.getLink()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });

        Resources resources = getResources();

        mArtist.setText(String.format(Locale.getDefault(),
                resources.getString(R.string.album_detailed_artist), album.getArtist()));
        mYear.setText(String.format(Locale.getDefault(),
                resources.getString(R.string.album_detailed_year), album.getYear()));
        mPrice.setText(String.format(Locale.getDefault(),
                resources.getString(R.string.album_detailed_price), album.getPrice(),
                resources.getString(R.string.ruble_symbol)));
        mGenre.setText(String.format(Locale.getDefault(),
                resources.getString(R.string.album_detailed_genre), album.getGenre()));
        mTracksCount.setText(String.format(Locale.getDefault(),
                resources.getString(R.string.album_detailed_tracks_count), album.getTracksCount()));

        new InternetChecker(new InternetChecker.Consumer() {
            @Override
            public void accept(Boolean internet) {
                if (internet) {
                    Caller.INSTANCE.lookupTracks(album.getId(), new ApiRequestCallback<TrackPOJO>() {
                        @Override
                        public void onSuccess(List<TrackPOJO> list) {
                            mTrackList = new ArrayList<>(list.size());
                            for (int i = 0; i < list.size(); i++) {
                                TrackPOJO curr = list.get(i);
                                mTrackList.add(i, new Track(
                                        curr.getTrackName(),
                                        curr.getCurrency(),
                                        curr.getTrackViewUrl(),
                                        curr.getTrackTimeMillis(),
                                        curr.getTrackPrice()
                                ));
                            }

                            mTracksAdapter = new TracksAdapter(mContext, mTrackList);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mTracksRecyclerView.setLayoutManager(mLayoutManager);
                            mTracksRecyclerView.setItemAnimator(new DefaultItemAnimator());
                            mTracksRecyclerView.setAdapter(mTracksAdapter);
                        }

                        @Override
                        public void onEmptyResponse() {
                            mTracksRecyclerView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.e(ALBUM_DETAIL_TAG + ERROR_TAG, t.getLocalizedMessage());
                            App.messageBox(mContext, "SearchButton.onClickListener", t.getMessage());
                        }
                    });
                }
                else {
                    Toast.makeText(mContext,
                            getResources().getString(R.string.no_available_internet_connection),
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
