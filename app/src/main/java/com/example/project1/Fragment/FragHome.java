package com.example.project1.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Adapter.LatestArticelAdapter;
import com.example.project1.Adapter.LatestEventAdapter;
import com.example.project1.Model.LatesArticleModel;
import com.example.project1.Model.LatestEventModel;
import com.example.project1.R;
import com.example.project1.Utils.ItemOffsetDecoration;
import com.example.project1.Utils.ScreenSize;

import java.util.ArrayList;
import java.util.List;

public class FragHome extends Fragment {
    private View mView;
    private ScreenSize mScreenSize;
    private ImageView imageView;
    private TextView mArticle;
    private Activity mActivity;
    private ImageView mSliderImage;

    private List<LatesArticleModel> mLatesArticleModels = new ArrayList<>();
    private List<LatestEventModel> mLatesEventModels = new ArrayList<>();
    private LatestArticelAdapter adapter;
    private LatestEventAdapter adapterEvent;
    private LinearLayoutManager mLinearLayoutManagerArticle;
    private LinearLayoutManager mLinearLayoutManagerEvent;
    private View view;
    private RecyclerView mNewArticle;
    private TextView mLatestEventText;
    private View view2;
    private RecyclerView mLatestEventRecycler;
    private TextView mPodcastText;
    private View view3;
    private ImageView mSliderImagePodcast;

    public FragHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_frag_home, container, false);
        mScreenSize = new ScreenSize(getActivity());
        initView();
        getData();

        return mView;
    }

    private void getData() {
        int[] mID = {1, 2, 3};
        String[] mTitle = {"Lorem ipsum dolor sit amet, const adipiscing elit ut aliquam", "Lorem ipsum dolor sit amet, const adipiscing elit ut aliquam", "Lorem ipsum dolor sit amet, const adipiscing elit ut aliquam"};
        String[] mLabel = {"Programming", "Design Grafis", "Animation"};

        for (int i = 0; i < mID.length; i++) {
            LatesArticleModel model = new LatesArticleModel();
            model.setArticle_id(mID[i]);
            model.setmTitle(mTitle[i]);
            model.setmLabel(mLabel[i]);

            mLatesArticleModels.add(model);
        }

        for (int i = 0; i < mID.length; i++) {
            LatestEventModel model = new LatestEventModel();
            model.setEventID(mID[i]);

            mLatesEventModels.add(model);
        }
        adapter = new LatestArticelAdapter(getActivity(), mLatesArticleModels);
        mNewArticle.setAdapter(adapter);

        adapterEvent = new LatestEventAdapter(getActivity(), mLatesEventModels);
        mLatestEventRecycler.setAdapter(adapterEvent);


    }

    private void initView() {
        imageView = (ImageView) mView.findViewById(R.id.mSliderImage);
        mArticle = (TextView) mView.findViewById(R.id.mArticle);
        mSliderImage = (ImageView) mView.findViewById(R.id.mSliderImage);
//        mSliderImage.getLayoutParams().width = mScreenSize.getWidth() / 2;
        mSliderImage.getLayoutParams().height = mScreenSize.getWidth() / 2;
        mNewArticle = (RecyclerView) mView.findViewById(R.id.mNewArticle);

        mLinearLayoutManagerArticle = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mNewArticle.setLayoutManager(mLinearLayoutManagerArticle);
        mNewArticle.setHasFixedSize(true);
        mNewArticle.addItemDecoration(new ItemOffsetDecoration(15));

        mLatestEventText = (TextView) mView.findViewById(R.id.mLatestEventText);
        mLatestEventRecycler = (RecyclerView) mView.findViewById(R.id.mLatestEventRecycler);

        mLinearLayoutManagerEvent = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mLatestEventRecycler.setLayoutManager(mLinearLayoutManagerEvent);
        mLatestEventRecycler.setHasFixedSize(true);
        mLatestEventRecycler.addItemDecoration(new ItemOffsetDecoration(15));
        mPodcastText = (TextView) mView.findViewById(R.id.mPodcastText);
        view3 = (View) mView.findViewById(R.id.view_3);
        mSliderImagePodcast = (ImageView) mView.findViewById(R.id.mSliderImagePodcast);
        mSliderImagePodcast.getLayoutParams().height = mScreenSize.getWidth() / 2;
    }
}