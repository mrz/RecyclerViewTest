package com.mrz.example.recyclerviewtest.network;

import com.mrz.example.recyclerviewtest.model.GalleryImage;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;

public interface Imgur {

    @GET("/3/gallery/random/random/")
    GalleryImage.List random(@Header("Authorization") String clientID);

    @GET("/3/gallery/random/random/{page}")
    GalleryImage.List random(@Header("Authorization") String clientID, @Path("page") String page);
}
