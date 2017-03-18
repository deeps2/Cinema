package com.shikhar.cinema.model;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable{

    private String mName;
    private String mDescription;
    private String mDuration;
    private float mRating;
    private int mThumbnailImage;
    private List<String> mVideoUrls;

    public Movie(String mName, String mDescription, String mDuration, float mRating, int mThumbnailImage, List<String> mVideoUrls) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mDuration = mDuration;
        this.mRating = mRating;
        this.mThumbnailImage = mThumbnailImage;
        this.mVideoUrls = mVideoUrls;
    }

    public float getmRating() {
        return mRating;
    }

    public int getmThumbnailImage() {
        return mThumbnailImage;
    }

    public String getmName() {
        return mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmDuration() {
        return mDuration;
    }

    public List<String> getmVideoUrls() {
        return mVideoUrls;
    }

}
