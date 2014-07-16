package com.mrz.example.recyclerviewtest.utils;

public class Constants {
    // Consider valid only images that specify this link. Imgur considers optional the extension,
    // so technically they are still valid links even if they don't specify the extension, but
    // this makes for less headache-y code.
    public static final String VALID_LINK_PTRN = "(http://i.imgur.com/\\w+)(\\.)?(jpg|png|gif)?";
}
