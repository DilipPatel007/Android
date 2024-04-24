package com.dilip.swipablebottomnavigationbar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager
        ViewPager viewPager = findViewById(R.id.view_pager);

        // Create Fragment List
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ChatsFragment());
        fragments.add(new UpdatesFragment());
        fragments.add(new CallsFragment());

        // Create FragmentAdapter
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        // Handle BottomNavigationView clicks
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.chats) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.updates) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.calls) {
                    viewPager.setCurrentItem(2);
                    return true;
                } else {
                    return false;
                }
            }
        });

        // Implement swipe listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Optional code to handle scroll events
            }

            @Override
            public void onPageSelected(int position) {
                // Update BottomNavigationView selection based on current viewpager position
                navView.getMenu().findItem(getSelectedItemId(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Optional code to handle scroll state changes
            }

            private int getSelectedItemId(int position) {
                switch (position) {
                    case 0:
                        return R.id.chats;
                    case 1:
                        return R.id.updates;
                    case 2:
                        return R.id.calls;
                    default:
                        return -1; // Handle potential out of bounds errors
                }
            }
        });
    }
}
