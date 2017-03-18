package com.shikhar.cinema.model;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable{

    private String mName;
    private String mDescription;
    private String mDuration;
    private double mRating;
    private int mThumbnailImage;
   // private String mVideoUrl1;
   // private String mVideoUrl2;
   // private String mVideoUrl3;
    private List<String> mVideoUrls;

    public Movie(String mName, String mDescription, String mDuration, double mRating, int mThumbnailImage, /*String mVideoUrl1, String mVideoUrl2, String mVideoUrl3,*/List<String> mVideoUrls) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mDuration = mDuration;
        this.mRating = mRating;
        this.mThumbnailImage = mThumbnailImage;
       // this.mVideoUrl1 = mVideoUrl1;
       // this.mVideoUrl2 = mVideoUrl2;
       // this.mVideoUrl3 = mVideoUrl3;
        this.mVideoUrls = mVideoUrls;
    }

    public double getmRating() {
        return mRating;
    }

    public void setmRating(double mRating) {
        this.mRating = mRating;
    }

    public int getmThumbnailImage() {
        return mThumbnailImage;
    }

    public void setmThumbnailImage(int mThumbnailImage) {
        this.mThumbnailImage = mThumbnailImage;
    }
    /*
    public String getmVideoUrl1() {
        return mVideoUrl1;
    }

    public void setmVideoUrl1(String mVideoUrl1) {
        this.mVideoUrl1 = mVideoUrl1;
    }

    public String getmVideoUrl2() {
        return mVideoUrl2;
    }

    public void setmVideoUrl2(String mVideoUrl2) {
        this.mVideoUrl2 = mVideoUrl2;
    }

    public String getmVideoUrl3() {
        return mVideoUrl3;
    }

    public void setmVideoUrl3(String mVideoUrl3) {
        this.mVideoUrl3 = mVideoUrl3;
    }
*/
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDuration() {
        return mDuration;
    }

    public void setmDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        this.mRating = rating;
    }

    public List<String> getmVideoUrls() {
        return mVideoUrls;
    }

    public void setmVideoUrls(List<String> mVideoUrls) {
        this.mVideoUrls = mVideoUrls;
    }
}
