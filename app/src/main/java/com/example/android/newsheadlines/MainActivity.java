package com.example.android.newsheadlines;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView) findViewById(R.id.timesofindia);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="the-times-of-india&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv2 = (TextView) findViewById(R.id.abcnews);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="abc-news-au&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv3 = (TextView) findViewById(R.id.thehindu);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="the-hindu&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv4 = (TextView) findViewById(R.id.dailymail);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="daily-mail&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv5 = (TextView) findViewById(R.id.businessinsider);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="business-insider&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv6 = (TextView) findViewById(R.id.bccsports);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="bbc-sport&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv7 = (TextView) findViewById(R.id.buzzfeed);
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="buzzfeed&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv8 = (TextView) findViewById(R.id.cnbc);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="cnbc&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv9 = (TextView) findViewById(R.id.cnn);
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="cnn&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv10 = (TextView) findViewById(R.id.fortune);
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="fortune&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv11 = (TextView) findViewById(R.id.hackernews);
        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="hacker-news&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv12 = (TextView) findViewById(R.id.thewallstreetjournal);
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="the-wall-street-journal&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv13 = (TextView) findViewById(R.id.mtvnews);
        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="mtv-news&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv14 = (TextView) findViewById(R.id.engadget);
        tv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="engadget&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        TextView tv15 = (TextView) findViewById(R.id.googlenews);
        tv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="google-news&sortBy=top&apiKey=8f9cb95efb514df2a4207a29f0b11017";
                Intent intent = new Intent(getBaseContext(), NewsDisplay.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }

}
