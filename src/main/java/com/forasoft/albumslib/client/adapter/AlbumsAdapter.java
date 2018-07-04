package com.forasoft.albumslib.client.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.forasoft.albumslib.R;
import com.forasoft.albumslib.client.activity.AlbumDetailActivity;
import com.forasoft.albumslib.client.activity.SearchAlbumActivity;
import com.forasoft.albumslib.client.model.Album;
import com.forasoft.albumslib.client.util.InternetChecker;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import static com.forasoft.albumslib.client.util.App.ALBUM_DATA_TAG;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {
    private SearchAlbumActivity mContext;
    private LayoutInflater mInflater;
    private List<Album> albumsList;

    class AlbumsViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout albumContainer;
        ImageView albumCover;
        TextView albumTitle;
        TextView albumAuthor;
        TextView albumTracksCount;
        TextView albumYear;
        TextView albumPrice;

        AlbumsViewHolder(View view) {
            super(view);

            albumContainer = view.findViewById(R.id.albums_row_container);
            albumCover = view.findViewById(R.id.albums_row_cover);
            albumTitle = view.findViewById(R.id.albums_row_title);
            albumAuthor = view.findViewById(R.id.albums_row_author);
            albumTracksCount = view.findViewById(R.id.albums_row_tracks_count);
            albumYear = view.findViewById(R.id.albums_row_year);
            albumPrice = view.findViewById(R.id.albums_row_price);
        }
    }

    public AlbumsAdapter(SearchAlbumActivity context, List<Album> albumsList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.albumsList = albumsList;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.albums_list_row, parent, false);

        return new AlbumsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AlbumsViewHolder holder, final int position) {
        final Album album = albumsList.get(position);

        holder.albumTitle.setText(album.getTitle());
        holder.albumAuthor.setText(album.getArtist());
        holder.albumTracksCount.setText(String.format(Locale.getDefault(),
                mContext.getResources().getString(R.string.albums_adapter_tracks_count),
                album.getTracksCount()));
        holder.albumPrice.setText(String.format(Locale.getDefault(), "%d %s", album.getPrice(), album.getCurrency()));
        holder.albumYear.setText(String.valueOf(album.getYear()));

        new InternetChecker(new InternetChecker.Consumer() {
            @Override
            public void accept(Boolean internet) {
                if (internet) {
                    Picasso.get()
                            .load(album.getCoverPath())
                            .placeholder(R.drawable.ic_library_music_pink_72dp)
                            .networkPolicy(NetworkPolicy.OFFLINE)
                            .into(holder.albumCover, new Callback() {
                                @Override
                                public void onSuccess() {
                                }

                                @Override
                                public void onError(Exception e) {
                                    //Try again online if cache failed
                                    Picasso.get()
                                            .load(album.getCoverPath())
                                            .error(R.drawable.ic_error_24dp)
                                            .into(holder.albumCover, new Callback() {
                                                @Override
                                                public void onSuccess() {
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
                            mContext.getResources().getString(R.string.no_available_internet_connection),
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        holder.albumContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, AlbumDetailActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mContext, holder.albumCover,
                                ViewCompat.getTransitionName(holder.albumCover));
                i.putExtra(ALBUM_DATA_TAG, album);
                mContext.startActivity(i, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    public void clear() {
        final int size = albumsList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                albumsList.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }
}
