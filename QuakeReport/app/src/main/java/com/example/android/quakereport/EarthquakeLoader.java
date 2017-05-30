package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by TruongVu on 29/5/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>>{
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if(mUrl == null) return null;
        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
