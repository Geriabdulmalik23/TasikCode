package com.example.project1.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.example.project1.Fragment.FragAccount;
import com.example.project1.Fragment.FragBlog;
import com.example.project1.Fragment.FragEvent;
import com.example.project1.Fragment.FragHome;
import com.example.project1.R;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private AHBottomNavigation bottomNavigation;
    private AHBottomNavigationAdapter navigationAdapter;
    int[] tabColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initUI();
    }

    public void initUI() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

        AHBottomNavigation.TitleState titleState = AHBottomNavigation.TitleState.valueOf("ALWAYS_SHOW");
        bottomNavigation.setAccentColor(Color.parseColor("#162447"));
        bottomNavigation.setInactiveColor(Color.parseColor("#CACDD3"));
        bottomNavigation.setTitleState(titleState);

        tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation_item);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);

        bottomNavigation.setCurrentItem(0);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,
                        createFragment(0),
                        createItemDescription(0))
                .commit();


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (!wasSelected) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout,
                                    createFragment(position),
                                    createItemDescription(position))
                            .commit();
                }
                return true;
            }
        });

        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {
            }
        });
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
    }

    private Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragHome();
            case 1:
                return new FragBlog();
            case 2:
                return new FragEvent();
            case 3:
                return new FragAccount();
        }
        throw new IllegalArgumentException();
    }

    private String createItemDescription(int position) {
        switch (position) {
            case 0:
                return "";
            case 1:
                return "";
            case 2:
                return "";
            case 3:
                return "";
        }
        throw new IllegalArgumentException();
    }
}