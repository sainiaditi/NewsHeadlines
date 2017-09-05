package com.example.android.newsheadlines;

/**
 * Created by Dell on 9/5/2017.
 */

public class News {
    private String nPublishedat;
    private String nTitle;
    private String nUrl;
    private String nImage;

    public News(String publishedat, String title, String url, String image) {
        nPublishedat = publishedat;
        nTitle = title;
        nUrl = url;
        nImage = image;
    }

    public String getnPublishedat() {
        return nPublishedat;
    }

    public String getnTitle() {
        return nTitle;
    }

    public String getnUrl() {
        return nUrl;
    }

    public String getnImage(){
        return nImage;
    }
}
