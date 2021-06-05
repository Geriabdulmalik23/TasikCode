package com.example.project1.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Model.CategoryModel;
import com.example.project1.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Activity activity;
    private List<CategoryModel> modelList;
    private List<LinearLayout> LinearLayoutList = new ArrayList<>();

    public CategoryAdapter(Activity activity, List<CategoryModel> modelList) {
        this.activity = activity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel model = modelList.get(position);

        if (!LinearLayoutList.contains(holder.mLinearCategory)) {
            LinearLayoutList.add(holder.mLinearCategory);
        }
        holder.mTitle.setText(model.getmCategoryName());
        holder.mLinearCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (LinearLayout layout : LinearLayoutList) {
                    layout.setBackgroundResource(R.drawable.bg_category_white);
                    holder.mTitle.setTextColor(Color.parseColor("#162447"));
                }
                holder.mLinearCategory.setBackgroundResource(R.drawable.bg_category_blue);
                holder.mTitle.setTextColor(Color.parseColor("#FFFFFFFF"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLinearCategory;
        public TextView mTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLinearCategory = (LinearLayout) itemView.findViewById(R.id.mLinearCategory);
            mTitle = (TextView) itemView.findViewById(R.id.mTitle);
        }
    }
}
