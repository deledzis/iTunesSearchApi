package com.forasoft.albumslib.client.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.forasoft.albumslib.client.util.App;
import com.forasoft.albumslib.R;
import com.forasoft.albumslib.client.model.Track;

import java.util.List;
import java.util.Locale;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TracksViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Track> mTrackList;

    class TracksViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout trackContainer;
        TextView trackPosition;
        TextView trackTitle;
        TextView trackPrice;
        TextView trackDuration;

        TracksViewHolder(View view) {
            super(view);

            trackContainer = view.findViewById(R.id.tracks_row_container);
            trackPosition = view.findViewById(R.id.tracks_row_position);
            trackTitle = view.findViewById(R.id.tracks_row_title);
            trackPrice = view.findViewById(R.id.tracks_row_price);
            trackDuration = view.findViewById(R.id.tracks_row_duration);
        }
    }

    public TracksAdapter(Context context, List<Track> mTrackList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mTrackList = mTrackList;
    }

    @NonNull
    @Override
    public TracksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.track_list_row, parent, false);

        return new TracksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TracksViewHolder holder, final int position) {
        final Track track = mTrackList.get(position);

        holder.trackTitle.setText(track.getTitle());
        holder.trackPosition.setText(String.valueOf(position + 1));
        holder.trackPrice.setText(String.format(Locale.getDefault(), "%d %s", track.getPrice(), track.getCurrency()));
        holder.trackDuration.setText(App.convertMillisToStringTimeFormat(track.getDuration()));

        holder.trackContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(track.getLink()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    mContext.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    public void clear() {
        final int size = mTrackList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                mTrackList.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }
}
