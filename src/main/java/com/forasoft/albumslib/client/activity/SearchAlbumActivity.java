package com.forasoft.albumslib.client.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.forasoft.albumslib.R;
import com.forasoft.albumslib.client.adapter.AlbumsAdapter;
import com.forasoft.albumslib.client.model.Album;
import com.forasoft.albumslib.client.util.App;
import com.forasoft.albumslib.client.util.InternetChecker;
import com.forasoft.albumslib.server.request.ApiRequestCallback;
import com.forasoft.albumslib.server.request.Caller;
import com.forasoft.albumslib.server.response.model.album.AlbumPOJO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.forasoft.albumslib.client.util.App.ERROR_TAG;
import static com.forasoft.albumslib.client.util.App.SEARCH_ALBUM_TAG;

public class SearchAlbumActivity extends AppCompatActivity {
    private SearchAlbumActivity mContext;

    private Toolbar mToolbar;
    private LinearLayout mPlaceholder;
    private ImageView mPlaceholderImage;
    private TextView mPlaceholderText;
    private TextInputLayout mPlaceholderSearchInputLayout;
    private TextInputEditText mPlaceholderSearchInputBox;
    private AppCompatButton mPlaceholderSearchButton;
    private RecyclerView mAlbumsRecyclerView;
    private AlbumsAdapter mAlbumsAdapter;
    private List<Album> mAlbumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        // setting custom Toolbar as an ActionBar
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(mToolbar);

        mAlbumList = new ArrayList<>(); // initializing list of albums

        mAlbumsRecyclerView = findViewById(R.id.albums_list);
        mPlaceholder = findViewById(R.id.placeholder);
        mPlaceholderImage = findViewById(R.id.placeholder_image);
        mPlaceholderText = findViewById(R.id.placeholder_text);
        mPlaceholderSearchInputLayout = findViewById(R.id.placeholder_search_input_layout);
        mPlaceholderSearchInputBox = findViewById(R.id.placeholder_search_input_box);
        mPlaceholderSearchButton = findViewById(R.id.placeholder_search_button);

        mPlaceholderSearchInputBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    performAlbumsSearch();
                    return true;
                }

                return false;
            }
        });

        mPlaceholderSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
                //Find the currently focused view, so we can grab the correct window token from it.
                View view = mContext.getCurrentFocus();
                //hiding keyboard
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view != null ?
                            view.getWindowToken() : new View(mContext).getWindowToken(),
                            0);
                }

                performAlbumsSearch();
            }
        });
    }

    private void performAlbumsSearch() {
        new InternetChecker(new InternetChecker.Consumer() {
            @Override
            public void accept(Boolean internet) {
                if (internet) {

                    if (mPlaceholderSearchInputBox.getText().toString().isEmpty()) {
                        // user didn't enter anything
                        mPlaceholderSearchInputLayout.setError(getResources().getString(R.string.search_query_empty));
                    }
                    else {
                        mPlaceholderSearchInputLayout.setError(null); //if error was earlier
                        final String term = mPlaceholderSearchInputBox.getText().toString();
                        try {
                            // encoding in terms of iTunes Search API documentation
                            String urlEncodedTerm = URLEncoder.encode(term, "UTF-8");

                            Caller.INSTANCE.searchAlbum(urlEncodedTerm, new ApiRequestCallback<AlbumPOJO>() {
                                @Override
                                public void onSuccess(List<AlbumPOJO> list) {
                                    mAlbumList = new ArrayList<>(list.size());
                                    for (int i = 0; i < list.size(); i++) {
                                        // translating objects based on clear response JSON schema into inner
                                        // representation of Album model
                                        AlbumPOJO curr = list.get(i);
                                        mAlbumList.add(i, new Album(
                                                curr.getCollectionId(),
                                                curr.getArtistName(),
                                                curr.getCollectionName(),
                                                curr.getArtworkUrl100().replaceAll("100x100", "800x800"),
                                                curr.getPrimaryGenreName(),
                                                curr.getCurrency(),
                                                curr.getCollectionViewUrl(),
                                                Integer.parseInt(curr.getReleaseDate().substring(0, 4)),
                                                curr.getCollectionPrice(),
                                                curr.getTrackCount()
                                        ));
                                    }

                                    Collections.sort(mAlbumList,new Comparator<Album>() {
                                        @Override
                                        public int compare(Album o1, Album o2) {
                                            return o1.getTitle().compareTo(o2.getTitle());
                                        }
                                    });

                                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                                    getSupportActionBar().setTitle(term);

                                    mPlaceholder.setVisibility(View.GONE);
                                    mAlbumsRecyclerView.setVisibility(View.VISIBLE);

                                    mAlbumsAdapter = new AlbumsAdapter(mContext, mAlbumList);
                                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                    mAlbumsRecyclerView.setLayoutManager(mLayoutManager);
                                    mAlbumsRecyclerView.setItemAnimator(new DefaultItemAnimator());
                                    mAlbumsRecyclerView.setAdapter(mAlbumsAdapter);
                                }

                                @Override
                                public void onEmptyResponse() {
                                    mPlaceholderImage.setImageDrawable(getResources()
                                            .getDrawable(R.drawable.ic_sentiment_dissatisfied_48dp));
                                    mPlaceholderSearchInputBox.setText("");
                                    mPlaceholderText.setText(R.string.nothing_found);
                                    mPlaceholderSearchButton.setText(R.string.try_again);
                                }

                                @Override
                                public void onError(Throwable t) {
                                    Log.e("Retrofit" + ERROR_TAG, t.toString());
                                    Log.e("Retrofit" + ERROR_TAG, t.getMessage());
                                    Toast.makeText(mContext, R.string.unexpected_error, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (UnsupportedEncodingException pE) {
                            Log.e(SEARCH_ALBUM_TAG + ERROR_TAG, pE.getLocalizedMessage());
                            App.messageBox(mContext, "SearchButton.onClickListener", pE.getMessage());
                        }
                    }
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

    @Override
    public void onBackPressed() {
        if (mAlbumList.size() > 0) {
            mAlbumsAdapter.clear();

            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(R.string.toolbar_title);

            mAlbumsRecyclerView.setVisibility(View.GONE);
            mPlaceholder.setVisibility(View.VISIBLE);

            mPlaceholderImage.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_music_note_pink_72dp));
            mPlaceholderText.setText(R.string.start_search);
            mPlaceholderSearchInputBox.setText("");
            mPlaceholderSearchButton.setText(R.string.lets_start);
        } else {
            super.onBackPressed();
        }
    }
}
