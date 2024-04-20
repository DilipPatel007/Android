package com.example.bottomnavigationwithtablayoutdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    // Member variables for UI components (already initialized in onCreate)
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter adapter;
    private FrameLayout frameLayout;
    private BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for this activity

        // Initialize UI components
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(this); // Create a new ViewPagerAdapter instance
        viewPager2.setAdapter(adapter); // Set the adapter for the ViewPager2

        // Bottom navigation setup
        bnView = findViewById(R.id.bnView);
        frameLayout = findViewById(R.id.container);

        // Handle tab selection events (switching between tabs in ViewPager2)
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Show ViewPager2 and hide FrameLayout
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);

                // Set the current item of ViewPager2 based on the selected tab
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // No specific action needed here (optional)
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                
            }
        });

        // Handle page change events in ViewPager2 (updating TabLayout selection)
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                        // Select the corresponding tab in TabLayout
                        tabLayout.getTabAt(position).select();
                        break;
                }
            }
        });

        // Handle bottom navigation item selection
        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Show FrameLayout and hide ViewPager2
                frameLayout.setVisibility(View.VISIBLE);
                viewPager2.setVisibility(View.GONE);

                int itemId = item.getItemId();
                if (itemId == R.id.nav_Library) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new LibraryFragment())
                            .commit();
                } else if (itemId == R.id.nav_Updates) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new UpdatesFragment())
                            .commit();
                } else if (itemId == R.id.nav_History) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new HistoryFragment())
                            .commit();
                } else if (itemId == R.id.nav_Browse) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new BrowseFragment())
                            .commit();
                } else if (itemId == R.id.nav_More) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new MoreFragment())
                            .commit();
                }
                return true;
            }
        });
    }
}


//        // Set listener for navigation item selection
//        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id = menuItem.getItemId();
//
//                // Handle navigation item clicks
//                if (id == R.id.nav_Library) {
//                    loadFragment(new LibraryFragment(), 1);
//
//                } else if (id == R.id.nav_Updates) {
//                    loadFragment(new UpdatesFragment(), 1);
//
//                } else if (id == R.id.nav_History) {
//                    loadFragment(new HistoryFragment(), 1);
//
//                } else if (id == R.id.nav_Browse) {
//                    loadFragment(new BrowseFragment(), 1);
//
//                } else { // More
//                    loadFragment(new MoreFragment(), 1);
//
//                }
//                return true; // Consumed the event, prevent reselection handling
//            }
//        });
//
//        // Set default fragment
//        bnView.setSelectedItemId(R.id.nav_Browse);
//    }
//
//    public void loadFragment(Fragment fragment, int flag) {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        if (flag == 0) {
//            ft.add(R.id.container, fragment);
//        } else {
//            ft.replace(R.id.container, fragment);
//        }
//        ft.commit();
//    }

