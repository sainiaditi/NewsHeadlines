package com.example.android.newsheadlines;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsDisplay extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>{

    private String URL_1 = "https://newsapi.org/v1/articles?source=";
    NewsAdapter newsAdapter;
    TextView empty_view_setter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_display);

        String toText = getIntent().getStringExtra("url");
        URL_1 += toText;

        empty_view_setter=(TextView)findViewById(R.id.empty_text_view);
        newsAdapter=new NewsAdapter(this,new ArrayList<News>());
        ListView list_view=(ListView)findViewById(R.id.list_view);
        list_view.setEmptyView(empty_view_setter);
        list_view.setAdapter(newsAdapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                News currentNews=newsAdapter.getItem(position);
                String url=currentNews.getnUrl();
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ConnectivityManager conn_mgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo network_info = conn_mgr.getActiveNetworkInfo();
        if (network_info != null && network_info.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.progress_bar);
            loadingIndicator.setVisibility(View.GONE);
            empty_view_setter.setText("No Internet Connection");
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(this,URL_1);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        empty_view_setter.setText("No Results Found");
        newsAdapter.clear();
        if (news != null && !news.isEmpty()) {

            newsAdapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        newsAdapter.clear();
    }
}
