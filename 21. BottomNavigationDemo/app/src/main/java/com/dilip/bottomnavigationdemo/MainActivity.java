package com.dilip.bottomnavigationdemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnView; // Use private for member variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        // Set listener for navigation item selection
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                // Handle navigation item clicks
                if (id == R.id.nav_Library) {
                    loadFragment(new LibraryFragment(), 1);

                } else if (id == R.id.nav_Updates) {
                    loadFragment(new UpdatesFragment(), 1);

                } else if (id == R.id.nav_History) {
                    loadFragment(new HistoryFragment(), 1);

                } else if (id == R.id.nav_Browse) {
                    loadFragment(new BrowseFragment(), 1);

                } else { // More
                    loadFragment(new MoreFragment(), 1);

                }
                return true; // Consumed the event, prevent reselection handling
            }
        });

        // Set default fragment
        bnView.setSelectedItemId(R.id.nav_Browse);
    }

    public void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0) {
            ft.add(R.id.container, fragment);
        } else {
            ft.replace(R.id.container, fragment);
        }
        ft.commit();
    }
}
