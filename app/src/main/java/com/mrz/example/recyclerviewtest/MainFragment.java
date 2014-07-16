package com.mrz.example.recyclerviewtest;

import com.mrz.example.recyclerviewtest.model.GalleryImage;
import com.mrz.example.recyclerviewtest.network.ImgurRandomImageSpiceRequest;
import com.mrz.example.recyclerviewtest.utils.Constants;
import com.mrz.example.recyclerviewtest.utils.GenerateTag;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.squareup.picasso.Picasso;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainFragment extends Fragment {

    private ImageView mImageView;

    private ImgurRandomImageSpiceRequest imgurRequest;

    private final String tag = GenerateTag.generateTag(MainFragment.class.getSimpleName());

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public MainFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).getSpiceManager().execute(imgurRequest,
                "randomImage",
                DurationInMillis.ONE_MINUTE,
                new RandomImageRequestListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgurRequest = new ImgurRandomImageSpiceRequest(getActivity(), null);
    }

    private final class RandomImageRequestListener implements RequestListener<GalleryImage.List> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Log.e(tag, "Failure");
        }

        @Override
        public void onRequestSuccess(GalleryImage.List galleryImages) {
            GalleryImage.List data = new GalleryImage.List();

            Log.i(tag, "Success");

            // Filter out images with links not conforming the above pattern. While valid links,
            // it simplifies rewriting the link for the thumbnail later on, and since we're dealing
            // with random images anyway it's not like it matters if we lose a couple here.
            for(GalleryImage image: galleryImages) {
                if (image.getLink().matches(Constants.VALID_LINK_PTRN)) {
                    data.add(image);
                }
            }

            GalleryImageAdapter adapter = new GalleryImageAdapter(getActivity(), data);
            mRecyclerView.setAdapter(adapter);
        }
    }
}
