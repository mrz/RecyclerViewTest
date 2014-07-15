package com.mrz.example.recyclerviewtest.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class GalleryImage {

    int datetime;       // Time inserted into the gallery, epoch time

    int bandwidth;      // Bandwidth consumed by the image in bytes

    boolean nsfw;       // Is the image NSFW

    String vote;        // The current user's vote on the album. null if not signed in or if the user hasn't voted on it.

    String id;          // The ID for the image

    int account_id;     // The account ID of the account that uploaded it, or null.

    String title;       // The title of the image.

    String section;     // If the image has been categorized by our backend then this will contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)

    int width;          // The width of the image in pixels

    int score;          // Imgur popularity score

    int size;           // The size of the image in bytes

    String type;        // Image MIME type.

    String description; // Description of the image.

    int views;          // The number of image views

    int downs;          // Number of downvotes for the image

    boolean is_album;   // If it's an album or not

    String link;        // The direct link to the the image

    int height;         // The height of the image in pixels

    boolean favorite;   // Indicates if the current user favorited the image. Defaults to false if not signed in.

    String account_url; // The username of the account that uploaded it, or null.

    boolean animated;   // Is the image animated

    int ups;            // Upvotes for the image

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    public int getViews() {
        return views;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public String getLink() {
        return link;
    }

    public String getVote() {
        return vote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getSection() {
        return section;
    }

    public String getAccount_url() {
        return account_url;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getUps() {
        return ups;
    }

    public int getDowns() {
        return downs;
    }

    public int getScore() {
        return score;
    }

    public boolean isIs_album() {
        return is_album;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public static class List extends ArrayList<GalleryImage> {
    }
}
