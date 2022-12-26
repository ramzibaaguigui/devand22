package com.devfest.navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.devfest.navigation.fragment.AddMeasurementFragment;
import com.devfest.navigation.fragment.DiscussionFragment;
import com.devfest.navigation.fragment.HomeFragment;
import com.devfest.navigation.fragment.NotificationsFragment;

public class ViewPagerStateAdapter extends FragmentStateAdapter {
    private static final int FRAGMENT_COUNT = 4;

    public ViewPagerStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new HomeFragment();
        }
        if (position == 1) {
            return new DiscussionFragment();
        }

        if (position == 2) {
            return new AddMeasurementFragment();
        }
        return new NotificationsFragment();
    }


    @Override
    public int getItemCount() {
        return FRAGMENT_COUNT;
    }
}
