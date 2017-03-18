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

    //boolean variables to find out whether player instance was released or not; whether back button was pressed or not; whether device is in fullscreen mode or not
    boolean playerReleased = true;
    boolean backPressed = false;
    boolean portraitMode = true;

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

        //set movie name, its summary, duration & ratings
        mMovieName.setText(mMovie.getmName());
        mMovieDescription.setText(mMovie.getmDescription());
        mRuntime.setText("Running Time : " + mMovie.getmDuration());

        if (mMovie.getmRating() == -1.0) {
            mRatingBar.setVisibility(GONE); //for upcoming movies, ratings are -1.0, so hide rating bar
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
        playerReleased = false; //false because Initialisation is successful, it will be false during mPlayer.release()

        //for handling YouTube Player State
        mPlayer.setPlayerStateChangeListener(playerStateChangeListener);

        /*
        state of YouTube view full screen, if it's true it means player is gone to full screen mode and if it
        is false it means the player is switched back from full screen mode and this listener is
        called both times when you go to full screen mode and come back from full screen mode with
        true and false value respectively.
         */
        mPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {
                if (b) {   //player went to full screen mode

                    backPressed = false;  //this is needed in order to differentiate 2 events
                                          // "(1)when back was click in full screen mode(then player should stop)" AND
                                          //"(2)when device was rotated from landscape to portrait mode(then player shouldn't stop)"

                    portraitMode = false; //as player is in full screen(i.e landscape mode), so set portraitMode boolean to false

                } else { // player exit from full screen mode

                    if(backPressed) { //check whether player exit from full screen mode because "back was pressed" or "device was rotated"(above 2 events)
                        youTubeView.setVisibility(View.INVISIBLE);  //TRUE means back button was pressed in full screen mode, so stop the player
                        mPlayer.release();
                        playerReleased = true;   //as player is released now, so set playerReleased = true;
                        backPressed = false;    //reset backPressed boolean to initial state i.e false
                        portraitMode = true;    //as player is not running in full screen mode, so set portraitMode = true;

                    }else    //FALSE means back button was not pressed and player exit from full screen mode because device was rotated. In this case don't stop the player
                        portraitMode = true;  // as player is not running in full screen mode, so set portraitMode = true;
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

        backPressed = true;

        if (youTubeView.getVisibility() == View.INVISIBLE) { //if YouTube view is invisible, go to previous activity
            super.onBackPressed();
        } else { // If YouTube view is visible

            if(!portraitMode)            //If YouTube view is visible and its in full screen mode when back was pressed
                 mPlayer.setFullscreen(false); //exit from fullscreen mode. This will also trigger mPlayer.setOnFullscreenListener()

            else //If YouTube view is visible and its in portrait mode when back was pressed.
            {
                //mPlayer.setFullscreen(false); //you can't call this expression(same as one in above if condition), otherwise below expression for visibility doesn't work
                youTubeView.setVisibility(View.INVISIBLE);
                mPlayer.release();
                playerReleased = true;        //as player is now released, so set the corresponding boolean variable to true
                backPressed = false;         //reset the backPressed variable to initial value(false)
                portraitMode = true;         //reset hte portraitMode variable to initial value(true)
            }
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
            mPlayer.play(); //start playing the video when YouTube view loading is over, otherwise user has to press one more time to start playing the video
        }
    }
}
