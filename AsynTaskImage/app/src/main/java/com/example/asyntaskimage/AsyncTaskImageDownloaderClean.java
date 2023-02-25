package com.example.asyntaskimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// This file was created and inspired from different sources, unknown at this time

// We are loaded an image and displaying it on the screen

// AsyncTask<String, Integer, Bitmap> - String is the url passed from execute,
// Integer is the status of the operation (here loading or loaded image) and
// Bitmap is the retrieved image

public class AsyncTaskImageDownloaderClean extends AsyncTask<String, Integer, Bitmap> {

    // Constant for the logs
    public static final String ASYNCTASKIMAGEDOWNLOAD = "ASYNCTASKIMAGEDOWNLOAD";

    // Status of the download of the image - LOADING = 0 and LOADED = 1
    public static final int LOADING = 0;
    public static final int LOADED = 1;
    private Activity myActivity;

    public AsyncTaskImageDownloaderClean(Activity activity) {
        myActivity = activity;
    }

    @Override
    // The long operation is executed in the background. The string (url) is the input parameter.
    // The image is first loading and then it is loaded. The image is saved in a bitmap
    protected Bitmap doInBackground(String... strings) {
        publishProgress(LOADING);
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            } else {
                Log.i(ASYNCTASKIMAGEDOWNLOAD, "con ok");
            }

            InputStream is = con.getInputStream();
            publishProgress(LOADED);

            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e(ASYNCTASKIMAGEDOWNLOAD, "Failed to load image", e);
            Log.e(ASYNCTASKIMAGEDOWNLOAD, e.getMessage());
        }
        return null;
    }

    @Override
    // After the execution of the long operation to download the image we display the image
    // We change the content of the image of the layout with the one from the web
    // The image is retrieved using findViewById
    protected void onPostExecute(Bitmap bitmap) {
        ImageView iv = (ImageView) myActivity.findViewById(R.id.image_remote);
        if (iv == null) {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "iv null " + iv);
        }
        if (bitmap == null) {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "bitmap null " + bitmap);
        }
        if (iv != null && bitmap != null) {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "Bitmap found");
            iv.setImageBitmap(bitmap);
        } else {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "Problem with bitmap");
        }
    }

    @Override
    // When the image is loading, a textview with the text loading is present otherwise we display This is the image!
    protected void onProgressUpdate(Integer... values) {
        TextView tv = (TextView) myActivity.findViewById(R.id.textview_loading);
        if (values[0] == LOADING) {
            tv.setText("Loading...");
        } else {
            tv.setText("This is a random image!");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}

