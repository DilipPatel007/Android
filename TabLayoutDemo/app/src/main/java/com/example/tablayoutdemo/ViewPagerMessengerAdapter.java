package com.example.tablayoutdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {

    // Reference to the FragmentManager for creating fragments
    private final FragmentManager fragmentManager;

    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentManager = fm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return a new fragment based on the current position
        switch (position) {
            case 0:
                return new ChatFragment();
            case 1:
                return new StatusFragment();
            default:
                return new CallsFragment();
        }
    }

    @Override
    public int getCount() {
        // Return the total number of tabs (3 in this case)
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Provide titles for each tab based on position
        switch (position) {
            case 0:
                return "Chats";
            case 1:
                return "Status";
            default:
                return "Calls";
        }
    }
}
