package com.mrz.example.recyclerviewtest.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.mrz.example.recyclerviewtest.model.GalleryImage;
import com.mrz.example.recyclerviewtest.model.GalleryImageDeserializer;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

public class ImgurSpiceService extends RetrofitGsonSpiceService {

    private static final String SERVER_URL = "https://api.imgur.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(Imgur.class);
    }

    @Override
    protected Converter createConverter() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(GalleryImage.List.class, new GalleryImageDeserializer())
                .create();

        return new GsonConverter(gson);
    }

    @Override
    protected String getServerUrl() {
        return SERVER_URL;
    }
}
