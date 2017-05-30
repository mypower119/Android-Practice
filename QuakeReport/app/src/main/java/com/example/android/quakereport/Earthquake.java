package com.example.android.quakereport;

/**
 * Created by TruongVu on 18/5/2017.
 */

public class Earthquake {

    private String mLocation;
    private long mTimeInMilliseconds;
    private double mMagnitude;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }
}
