package com.example.project1.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Model.LatesArticleModel;
import com.example.project1.R;

import java.util.List;

public class LatestArticelAdapter extends RecyclerView.Adapter<LatestArticelAdapter.ViewHolder> {
    private Activity activity;
    private List<LatesArticleModel> modelList;


    public LatestArticelAdapter(Activity activity, List<LatesArticleModel> modelList) {
        this.activity = activity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_latest_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LatesArticleModel articleModel = modelList.get(position);

        holder.mTitleArticle.setText(articleModel.getmTitle());
        holder.mLabel.setText(articleModel.getmLabel());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mArticleImage;
        public TextView mTitleArticle;
        public TextView mLabel;
        public TextView mTimePost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mArticleImage = (ImageView) itemView.findViewById(R.id.mArticleImage);
            mTitleArticle = (TextView) itemView.findViewById(R.id.mTitleArticle);
            mLabel = (TextView) itemView.findViewById(R.id.mLabel);
            mTimePost = (TextView) itemView.findViewById(R.id.mTimePost);

        }
    }
}
