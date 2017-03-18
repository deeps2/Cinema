package com.shikhar.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayerView;
import com.shikhar.cinema.model.Movie;
import java.util.List;

import static android.R.id.list;
import static android.os.Build.VERSION_CODES.M;
import static com.shikhar.cinema.R.id.trailer_thumbnail;
import static com.shikhar.cinema.R.id.trialer_no;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.InTheatersViewHolder> {

    private List<String> mTrailersLinks;
    private int mThumbnailImage;
    private YouTubePlayerView youTubeView;
    Context context;
    MovieDetailActivity activity;

    public static class InTheatersViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView trailerNo;

        public InTheatersViewHolder(View v) {
            super(v);
            thumbnail = (ImageView) v.findViewById(trailer_thumbnail);
            trailerNo = (TextView)v.findViewById(trialer_no);
        }
    }

    public TrailersAdapter(List<String> trailerLinks, int mThumbnailImage ,Context context, YouTubePlayerView v) {
        this.mTrailersLinks = trailerLinks;
        this.context = context;
        this.activity = (MovieDetailActivity)context;
        this.mThumbnailImage = mThumbnailImage;
        this.youTubeView = v;
    }

    @Override
    public TrailersAdapter.InTheatersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie_trailers, parent, false);
        return new TrailersAdapter.InTheatersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrailersAdapter.InTheatersViewHolder holder, final int position) {
        holder.thumbnail.setImageResource(mThumbnailImage);

        holder.trailerNo.setText(Integer.toString(position + 1));

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //play - mTrailersLinks.get(position);
               //open youtube api, unhide it in activity_movie_detail.xml
                youTubeView.setVisibility(View.VISIBLE);
                activity.initialisation(mTrailersLinks.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrailersLinks.size();
    }
}
