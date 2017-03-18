package com.shikhar.cinema;

import com.shikhar.cinema.model.Movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> mInTheaterMovieList = new ArrayList<>();
    List<Movie> mUpComingMovieList = new ArrayList<>();

    RecyclerView mInTheaterRecyclerView;
    RecyclerView mUpComingRecyclerView;

    MovieAdapter mMovieAdapter;
    MovieAdapter mUpcomingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add dummy content
        addSampleContent();

        //setting top recycler view (In Theaters)
        mInTheaterRecyclerView = (RecyclerView) findViewById(R.id.in_theaters);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        mInTheaterRecyclerView.setLayoutManager(gridLayoutManager);

        mMovieAdapter = new MovieAdapter(mInTheaterMovieList, this);
        mInTheaterRecyclerView.setAdapter(mMovieAdapter);
        mInTheaterRecyclerView.setHasFixedSize(true);


        //setting bottom recycler view (Upcoming Movies )
        mUpComingRecyclerView = (RecyclerView) findViewById(R.id.upcoming);

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        mUpComingRecyclerView.setLayoutManager(gridLayoutManager2);

        mUpcomingAdapter = new MovieAdapter(mUpComingMovieList, this);
        mUpComingRecyclerView.setAdapter(mUpcomingAdapter);
        mUpComingRecyclerView.setHasFixedSize(true);

    }

    void addSampleContent() {

        mInTheaterMovieList.add(new Movie("Rogue One",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 2",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 3",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 4",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 5",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 6",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 7",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 8",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 9",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mInTheaterMovieList.add(new Movie("Rogue One 10",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.2f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 11",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 12",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 13",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 14",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 15",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 16",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 17",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 18",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 19",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

        mUpComingMovieList.add(new Movie("Rogue One 20",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                -1.0f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8")));

    }

}
