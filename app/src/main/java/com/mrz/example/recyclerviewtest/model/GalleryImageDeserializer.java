package com.mrz.example.recyclerviewtest.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GalleryImageDeserializer implements JsonDeserializer<GalleryImage.List> {

    @Override
    public GalleryImage.List deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new GsonBuilder().create();
        JsonArray data = json.getAsJsonObject().get("data").getAsJsonArray();

        return gson.fromJson(data, new TypeToken<GalleryImage.List>() {}.getType());
    }
}
