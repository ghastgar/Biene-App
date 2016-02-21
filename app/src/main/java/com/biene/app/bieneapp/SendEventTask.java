package com.biene.app.bieneapp;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by JuanjoVG on 20/02/2016.
 */
public class SendEventTask extends AsyncTask<String, Void, Void> {
    private final String LOG_TAG = SendEventTask.class.getSimpleName();

    private final Context mContext;

    public SendEventTask(Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        return null;
    }

}
