package com.example.project1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.Adapter.CategoryAdapter;
import com.example.project1.Model.CategoryModel;
import com.example.project1.R;
import com.example.project1.Utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.List;


public class FragBlog extends Fragment {
    private View mView;
    private RecyclerView mListCategory;

    private CategoryAdapter adapter;
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    public FragBlog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_frag_blog, container, false);
        initView();
        initAdapter();

        return mView;
    }

    private void initAdapter() {
        int mCategoryId[] = {1, 2, 3, 4, 5, 6};
        String mCategoryName[] = {"#SEMUA", "#PROGRAMMER", "#DESIGNER", "#ENGINER", "#FREELANCE", "#WEB"};

        for (int i = 0; i < mCategoryId.length; i++) {
            CategoryModel model = new CategoryModel();
            model.setmCategoryId(mCategoryId[i]);
            model.setmCategoryName(mCategoryName[i]);

            categoryModelList.add(model);
        }
        adapter = new CategoryAdapter(getActivity(), categoryModelList);
        mListCategory.setAdapter(adapter);
    }

    private void initView() {
        mListCategory = (RecyclerView) mView.findViewById(R.id.mListCategory);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mListCategory.setLayoutManager(layoutManager);
        mListCategory.setHasFixedSize(true);
        mListCategory.addItemDecoration(new ItemOffsetDecoration((int) 4.5));
    }
}