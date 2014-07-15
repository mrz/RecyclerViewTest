package com.mrz.example.recyclerviewtest;

import com.mrz.example.recyclerviewtest.model.GalleryImage;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GalleryImageAdapter extends RecyclerView.Adapter<GalleryImageAdapter.ViewHolder> {

    private final ArrayList<GalleryImage> mDataSet;

    private final Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView thumbnail;

        private final TextView title;

        public ViewHolder(View view) {
            super(view);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            title = (TextView) view.findViewById(R.id.title);
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
        String link = mDataSet.get(i).getLink();
        String ptrn = "(http://i.imgur.com/\\w+)(\\.jpg|\\.png|\\.gif)";
        if(link.matches(ptrn)) {
            // We got a valid link
            String thumbnailLink = link.replaceAll(ptrn, "$1s$2"); // Construct thumbnail link: https://api.imgur.com/models/image

            Picasso.with(mContext).load(thumbnailLink).into(viewHolder.thumbnail);
            viewHolder.title.setText(mDataSet.get(i).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
