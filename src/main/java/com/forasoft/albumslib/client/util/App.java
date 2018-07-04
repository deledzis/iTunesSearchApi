package com.forasoft.albumslib.client.util;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class App extends Application {
    public static final String ITUNES_SEARCH_API_BASE_URL = "https://itunes.apple.com/";
    public static final String ALBUM_DATA_TAG = "album_tag";

    public static final String SEARCH_ALBUM_TAG = "SearchAlbum";
    public static final String ALBUM_DETAIL_TAG = "AlbumDetail";
    public static final String SUCCESS_TAG = "Success";
    public static final String ERROR_TAG = "Error";

    @Override
    public void onCreate() {
        super.onCreate();

        /* Configuring Picasso singleton instance */
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }

    public static String convertMillisToStringTimeFormat(long millis) {
        Date currentDate = new Date(millis);
        DateFormat df = new SimpleDateFormat("mm:ss", Locale.getDefault());

        return df.format(currentDate);
    }

    public static void messageBox(Context context, String method, String message)
    {
        Log.e(ERROR_TAG + " at " + method,  message);

        AlertDialog.Builder messageBox = new AlertDialog.Builder(context);
        messageBox.setTitle(method);
        messageBox.setMessage(message);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK", null);
        messageBox.show();
    }
}
