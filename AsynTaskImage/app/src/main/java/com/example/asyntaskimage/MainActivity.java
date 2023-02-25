package com.example.asyntaskimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call of AsyncTask class
        // Creation of the AsyncTask
        // Execution with a random image from picsum.photos
        AsyncTaskImageDownloader imgDownloader = new AsyncTaskImageDownloader(this);
        // Call without a file type
        imgDownloader.execute("https://picsum.photos/300");
        // Call with a file type
        // imgDownloader.execute("https://picsum.photos/200/300.jpg");
    }
}