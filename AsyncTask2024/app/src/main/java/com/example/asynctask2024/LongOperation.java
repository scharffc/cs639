package com.example.asynctask2024;

import android.os.AsyncTask;

public class LongOperation extends AsyncTask<String, Void, Integer> {

    @Override
    protected Integer doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
