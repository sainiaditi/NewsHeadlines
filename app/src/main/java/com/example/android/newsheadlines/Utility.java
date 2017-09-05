package com.example.android.newsheadlines;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 9/5/2017.
 */

public class Utility {
    private static List<News> news = new ArrayList<>();
    public static final String LOG_TAG = MainActivity.class.getName();

    public Utility() {
    }

    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            clearList();
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null)
            return jsonResponse;

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Bad response");
            }

        } catch (IOException e) {
            // TODO: Handle the exception
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    @NonNull
    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<News> fetchNewsData(String mUrl) {

        URL url = Utility.createUrl(mUrl);
        String jsonResponse = "";
        try {
            jsonResponse = Utility.makeHttpRequest(url);
        } catch (IOException e) {
        }
        extractFeatureFromJson(jsonResponse);
        return news;

    }

    private static void extractFeatureFromJson(String newsJSON) {

        if (TextUtils.isEmpty(newsJSON))
            return;
        try {

            // NEWS
            JSONObject root = new JSONObject(newsJSON);
            JSONArray articles = root.optJSONArray("articles");
            if (articles == null)
                return;
            for (int i = 0; i < (articles.length() > 10 ? 10 : articles.length()); i++) {
                JSONObject newsObject = articles.getJSONObject(i);
                String publishedat = newsObject.getString("publishedAt");
                String title = newsObject.getString("title");
                String url = newsObject.getString("url");
                String urlToImage = newsObject.getString("urlToImage");
                news.add(new News(publishedat, title, url, urlToImage));
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the news JSON results", e);
        }

    }

    public static void clearList() {
        news.clear();
    }
}
