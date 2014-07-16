package com.mrz.example.recyclerviewtest;

import android.app.Application;
import android.util.Log;

import com.mrz.example.recyclerviewtest.utils.GenerateTag;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainApp extends Application {
    private static final String tag = GenerateTag.generateTag(MainApp.class.getSimpleName());

    @Override
    public void onCreate() {
        super.onCreate();

        Properties props = new Properties();
        try {
            InputStream inputStream = getAssets().open("secrets.properties");
            props.load(inputStream);
            inputStream.close();

            getSharedPreferences("com.mrz.example.recyclerviewtest", MODE_PRIVATE).edit().putString("clientID", props.getProperty("clientID")).commit();
            getSharedPreferences("com.mrz.example.recyclerviewtest", MODE_PRIVATE).edit().putString("clientSecret", props.getProperty("clientSecret")).commit();
        } catch (IOException e) {
            Log.e(tag, "Could not find secrets.properties in assets folder");
            getSharedPreferences("com.mrz.example.recyclerviewtest", MODE_PRIVATE).edit().putString("clientID", "").commit();
            getSharedPreferences("com.mrz.example.recyclerviewtest", MODE_PRIVATE).edit().putString("clientSecret", "").commit();
        }
    }
}
