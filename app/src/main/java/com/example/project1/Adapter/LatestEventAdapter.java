package com.example.project1.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Model.LatestEventModel;
import com.example.project1.R;
import com.example.project1.Utils.ScreenSize;

import java.util.List;

public class LatestEventAdapter extends RecyclerView.Adapter<LatestEventAdapter.ViewHolder> {
    private Activity activity;
    private List<LatestEventModel> modelList;
    private ScreenSize mScreenSize;

    public LatestEventAdapter(Activity activity, List<LatestEventModel> modelList) {
        this.activity = activity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_latest_event, parent, false);
        ViewHolder viewHolder = new ViewHolder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LatestEventModel eventModel = modelList.get(position);
        mScreenSize = new ScreenSize(activity);
//        holder.itemView.getLayoutParams().width = mScreenSize.getWidth() / 2;
//        holder.itemView.getLayoutParams().height = mScreenSize.getWidth() / 2;
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.mEventImg);
        }
    }
}
