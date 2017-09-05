package com.example.android.newsheadlines;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.attr.category;

/**
 * Created by Dell on 9/5/2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }
        News currentNews = getItem(position);
        TextView publishedat = (TextView) listItemView.findViewById(R.id.publishesat);
        publishedat.setText(currentNews.getnPublishedat());
        TextView title = (TextView) listItemView.findViewById(R.id.news_view);
        title.setText(currentNews.getnTitle());
        String articleThumbnail = currentNews.getnImage();
        ImageView thumbnail_Image = (ImageView) listItemView.findViewById(R.id.image_view);

        Picasso.with(getContext())
                .load(articleThumbnail)
                .placeholder(R.mipmap.newsppr)
                .error(R.mipmap.newsppr)
                .noFade()
                .into(thumbnail_Image);


        return listItemView;
    }
}
