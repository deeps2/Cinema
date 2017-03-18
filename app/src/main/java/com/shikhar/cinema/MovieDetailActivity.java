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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.shikhar.cinema.model.Movie;

import static android.view.View.GONE;
import static com.shikhar.cinema.R.id.running_time;
import static com.shikhar.cinema.R.id.textView;

public class MovieDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //declare instance variables related to activity_movie_detail.xml's layout
    Movie mMovie;
    RecyclerView mTrailerListRecyclerView;
    TrailersAdapter mTrailersAdapter;
    TextView mMovieName;
    TextView mMovieDescription;
    TextView mRuntime;
    RatingBar mRatingBar;

    //declare instance variable related to YouTube View and player
    private YouTubePlayerView youTubeView;
    private YouTubePlayer mPlayer;
    private static final int RECOVERY_REQUEST = 1;
    String key = "AIzaSyCG25IwSEZcJuF5Te7kko9XawkHaEJ48Ws";
    String clickedTrailerUrl;

    private MyPlayerStateChangeListener playerStateChangeListener;
    boolean playerReleased = true;

    boolean backpressed = false;
    boolean potraitMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //findViewByIds
        mMovieName = (TextView) findViewById(R.id.movie_name);
        mMovieDescription = (TextView) findViewById(R.id.movie_description);
        mRuntime = (TextView) findViewById(running_time);
        mRatingBar = (RatingBar) findViewById(R.id.ratings);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        playerStateChangeListener = new MyPlayerStateChangeListener();

        //catch the intent
        mMovie = (Movie) getIntent().getSerializableExtra("CLICKED_MOVIE");

        //set horizontal linear layout to RecyclerView
        mTrailerListRecyclerView = (RecyclerView) findViewById(R.id.trailers_recyclerView);
        LinearLayoutManager horizontalLL = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mTrailerListRecyclerView.setLayoutManager(horizontalLL);

        //set adapter to fetch list of movie trailers
        mTrailersAdapter = new TrailersAdapter(mMovie.getmVideoUrls(), mMovie.getmThumbnailImage(), this, youTubeView);
        mTrailerListRecyclerView.setAdapter(mTrailersAdapter);

        //in order to place current selected item from the adapter in center
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mTrailerListRecyclerView);

        mMovieName.setText(mMovie.getmName());
        mMovieDescription.setText(mMovie.getmDescription());
        mRuntime.setText("Running Time : " + mMovie.getmDuration());

        //for upcoming movies, ratings are -1.0, so hide rating bar
        if (mMovie.getmRating() == -1.0) {
            mRatingBar.setVisibility(GONE);
        } else {
            mRatingBar.setRating(mMovie.getmRating());
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //if device is in landscape mode, make youtube view full screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE && !playerReleased)
            mPlayer.setFullscreen(true);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        mPlayer = player;
        playerReleased = false;
        mPlayer.setPlayerStateChangeListener(playerStateChangeListener);

        mPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {
                if (b) {
                    backpressed = false;
                    potraitMode = false;

                } else {

                    if(backpressed) {
                        youTubeView.setVisibility(View.INVISIBLE);
                        mPlayer.release();
                        playerReleased = true;
                        backpressed = false;
                        potraitMode = true;
                    }else
                        potraitMode = true;
                }
            }
        });


        if (!wasRestored) {
            mPlayer.cueVideo(clickedTrailerUrl); //pass the trailer url so that it will be played
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

    //will be called when a particular trailer in the RecyclerView is clicked
    void initialisation(String Url) {
        youTubeView.initialize(key, this);
        clickedTrailerUrl = Url;
    }

    @Override
    public void onBackPressed() {
        //  if(youTubeView.getVisibility() == View.VISIBLE && playerReleased){
        //  mPlayer.setFullscreen(false);
        //}
          backpressed = true;

        if (youTubeView.getVisibility() == View.INVISIBLE) {
            super.onBackPressed();
        } else {

           /// if(playerReleased == false)
           //     mPlayer.setFullscreen(false);


           // if (playerReleased == false) {

          // }


            //if player is not in fullscreen mode
           // if (playerReleased == false) {
            if(potraitMode == false)
                 mPlayer.setFullscreen(false);
            else
            {
                youTubeView.setVisibility(View.INVISIBLE);
                mPlayer.release();
                playerReleased = true;
                backpressed = false;
                potraitMode = true;
            }

               /* if(playerReleased == false) {
                    youTubeView.setVisibility(View.INVISIBLE);
                    mPlayer.release();
                    playerReleased = true;
                    backpressed = false;
                }*/
            //}// else


        }
    }

    //This class is for handling YouTube Player State
    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {
        @Override
        public void onLoading() {
            Log.d(getLocalClassName(), "Video still loading");
        }

        @Override
        public void onAdStarted() {
            Log.d(getLocalClassName(), "Ad started");
        }

        @Override
        public void onVideoStarted() {
            Log.d(getLocalClassName(), "Video Started");
        }

        @Override
        public void onVideoEnded() {
            Log.d(getLocalClassName(), "Video Ended");
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Log.d(getLocalClassName(), "Error" + errorReason);
        }

        @Override
        public void onLoaded(String s) {
            mPlayer.play();
        }
    }


    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            // showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            // showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            // showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

}
