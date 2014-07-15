package com.mrz.example.recyclerviewtest.network;

import com.mrz.example.recyclerviewtest.model.GalleryImage;
import com.mrz.example.recyclerviewtest.utils.GenerateTag;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class ImgurRandomImageSpiceRequest extends RetrofitSpiceRequest<GalleryImage.List, Imgur> {

    private final static String tag = GenerateTag.generateTag(ImgurRandomImageSpiceRequest.class.getSimpleName());

    private final String page;

    private final Context context;

    public ImgurRandomImageSpiceRequest(Context context, String page) {
        super(GalleryImage.List.class, Imgur.class);
        this.page = page;
        this.context = context;
    }

    @Override
    public GalleryImage.List loadDataFromNetwork() throws Exception {
        Log.i(tag, "Calling web service");

        String clientID = String.format("Client-ID %s",
                context.getSharedPreferences("com.mrz.example.recyclerviewtest", Context.MODE_PRIVATE).getString("clientID", null));

        if (page != null && StringUtils.isNotEmpty(page)) {
            return getService().random(clientID, page);
        } else {
            return getService().random(clientID);
        }
    }
}
