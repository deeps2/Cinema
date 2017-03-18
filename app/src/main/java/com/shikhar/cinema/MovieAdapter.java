package com.shikhar.cinema;

import com.shikhar.cinema.model.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.InTheatersViewHolder> {

    private List<Movie> mInTheaterMovieList;
    Context context;

    public static class InTheatersViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView moviename;

        public InTheatersViewHolder(View v) {
            super(v);
            poster = (ImageView) v.findViewById(R.id.poster);
            moviename = (TextView) v.findViewById(R.id.name);
        }
    }

    public MovieAdapter(List<Movie> list, Context context) {
        this.mInTheaterMovieList = list;
        this.context = context;
    }

    @Override
    public InTheatersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_intheater, parent, false);
        return new InTheatersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InTheatersViewHolder holder, final int position) {
        holder.poster.setImageResource(mInTheaterMovieList.get(position).getmThumbnailImage());
        holder.moviename.setText(mInTheaterMovieList.get(position).getmName());

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,MovieDetailActivity.class);
                i.putExtra("CLICKED_MOVIE",mInTheaterMovieList.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInTheaterMovieList.size();
    }

}
