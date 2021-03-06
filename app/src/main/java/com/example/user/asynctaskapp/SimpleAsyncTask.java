package com.example.user.asynctaskapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 9/8/2016.
 */

public class SimpleAsyncTask extends AsyncTask <Void, Void, String>  {

    private TextView mTextView;
    public SimpleAsyncTask(TextView tv) {
        mTextView = tv;
    }

    @Override
    protected String doInBackground(Void... params) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";

    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.setText(s);
    }

}
