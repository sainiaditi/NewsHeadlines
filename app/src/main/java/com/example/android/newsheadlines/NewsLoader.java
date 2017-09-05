package com.example.android.newsheadlines;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Dell on 9/5/2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String nUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        nUrl = url;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (nUrl == null) {
            return null;
        }
        List<News> news = Utility.fetchNewsData(nUrl);
        return news;
    }
}
