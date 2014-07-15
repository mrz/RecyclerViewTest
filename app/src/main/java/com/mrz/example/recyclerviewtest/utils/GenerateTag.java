package com.mrz.example.recyclerviewtest.utils;

/**
 * Created by dorian on 7/14/14.
 */
public class GenerateTag {
    public static String generateTag(String className) {
        return String.format("RecyclerViewTest[%s]", className);
    }
}
