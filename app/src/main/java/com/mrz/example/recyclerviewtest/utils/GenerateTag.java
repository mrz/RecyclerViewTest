package com.mrz.example.recyclerviewtest.utils;

public class GenerateTag {
    public static String generateTag(String className) {
        return String.format("RecyclerViewTest[%s]", className);
    }
}
