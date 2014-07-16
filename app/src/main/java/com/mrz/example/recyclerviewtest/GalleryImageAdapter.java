package com.mrz.example.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrz.example.recyclerviewtest.model.GalleryImage;
import com.mrz.example.recyclerviewtest.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryImageAdapter extends RecyclerView.Adapter<GalleryImageAdapter.ViewHolder> {

    private final ArrayList<GalleryImage> mDataSet;

    private final Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView thumbnail;

        private final TextView title;

        private final TextView user;

        public ViewHolder(View view) {
            super(view);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            title = (TextView) view.findViewById(R.id.title);
            user = (TextView) view.findViewById(R.id.user);
        }
    }

    GalleryImageAdapter(Context context, GalleryImage.List data) {
        this.mContext = context;
        this.mDataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_entry, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GalleryImage image = mDataSet.get(i);

        String link = image.getLink();
        String thumbnailLink = link.replaceAll(Constants.VALID_LINK_PTRN, "$1s$2$3"); // Construct thumbnail link: https://api.imgur.com/models/image

        Picasso.with(mContext).load(thumbnailLink).into(viewHolder.thumbnail);
        viewHolder.title.setText(image.getTitle());
        viewHolder.user.setText(image.getAccount_url() != null ? image.getAccount_url() : "Anonymous");
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
