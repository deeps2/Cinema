package com.shikhar.cinema;

import com.shikhar.cinema.model.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class InTheatersAdapter extends RecyclerView.Adapter<InTheatersAdapter.InTheatersViewHolder>{

    private List<Movie> mInTheaterMovieList;

    public static class InTheatersViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView moviename;

        public InTheatersViewHolder(View v){
            super(v);
            poster = (ImageView)v.findViewById(R.id.poster);
            moviename = (TextView)v.findViewById(R.id.name);
        }
    }

    public InTheatersAdapter(List<Movie> list){
        this.mInTheaterMovieList = list;
    }

    @Override
    public InTheatersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_intheater, parent, false);
        return new InTheatersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InTheatersViewHolder holder, int position) {
        holder.poster.setImageResource(mInTheaterMovieList.get(position).getmThumbnailImage());
        holder.moviename.setText(mInTheaterMovieList.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return mInTheaterMovieList.size() ;
    }


}
