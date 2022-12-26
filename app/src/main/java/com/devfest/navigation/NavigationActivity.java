package com.devfest.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.devfest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;
    private ViewPagerStateAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        assignViews();
        initNavigationView();
        initViewPager();
    }

    private void assignViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.viewpager);
    }

    private void initViewPager() {
        adapter = new ViewPagerStateAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void initNavigationView() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                char selected = item.getNumericShortcut();
                viewPager.setCurrentItem(Integer.parseInt(String.valueOf(selected)));
                return true;
            }
        });
    }


}
