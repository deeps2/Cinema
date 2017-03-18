package com.shikhar.cinema;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.shikhar.cinema.model.Movie;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MovieDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    Movie mMovie;
    RecyclerView mTrailerListRecyclerView;
    TextView mMovieDescription;
    TrailersAdapter mTrailersAdapter;
    String key="AIzaSyCG25IwSEZcJuF5Te7kko9XawkHaEJ48Ws";

    private YouTubePlayerView youTubeView;
    private YouTubePlayer mPlayer;
    private static final int RECOVERY_REQUEST = 1;
    String clickedTrailerUrl;

    private MyPlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMovieDescription = (TextView) findViewById(R.id.movie_description);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        playerStateChangeListener = new MyPlayerStateChangeListener();
        //youTubeView.initialize(key, this);

        mMovie = (Movie) getIntent().getSerializableExtra("CLICKED_MOVIE");

        mTrailerListRecyclerView = (RecyclerView) findViewById(R.id.trailers_recyclerView);
        LinearLayoutManager horizontalLL = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mTrailerListRecyclerView.setLayoutManager(horizontalLL);

        mTrailersAdapter = new TrailersAdapter(mMovie.getmVideoUrls(),mMovie.getmThumbnailImage(), this, youTubeView);
        mTrailerListRecyclerView.setAdapter(mTrailersAdapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mTrailerListRecyclerView);

        mMovieDescription.setText(mMovie.getmName());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            mPlayer.setFullscreen(true);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        mPlayer = player;
        mPlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if (!wasRestored) {
            mPlayer.cueVideo(clickedTrailerUrl); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = "Error initializing YouTube player" + errorReason.toString();
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            youTubeView.initialize(key, this);
        }
    }

    void initialisation(String Url){
        youTubeView.initialize(key, this);
        clickedTrailerUrl = Url;
    }

    @Override
    public void onBackPressed() {
        if(youTubeView.getVisibility() == View.INVISIBLE){
            super.onBackPressed();
        }
        else {
            mPlayer.release();
            youTubeView.setVisibility(View.INVISIBLE);
        }
    }
    
    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {
        @Override
        public void onLoading() {
            Log.d(getLocalClassName(),"Video still loading");
        }

        @Override
        public void onAdStarted() {
            Log.d(getLocalClassName(),"Ad started");
        }

        @Override
        public void onVideoStarted() {
            Log.d(getLocalClassName(),"Video Started");
        }

        @Override
        public void onVideoEnded() {
            Log.d(getLocalClassName(),"Video Ended");
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Log.d(getLocalClassName(),"Error" + errorReason);
        }

        @Override
        public void onLoaded(String s) {
            mPlayer.play();
        }
    }

}
