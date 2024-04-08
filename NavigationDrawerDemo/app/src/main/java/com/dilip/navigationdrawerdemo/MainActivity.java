package com.dilip.navigationdrawerdemo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    // Member variables for UI components
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for this activity

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();

        // Initialize UI components
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        // Set toolbar as the action bar for this activity
        setSupportActionBar(toolbar);

        // Create a DrawerToggle for handling drawer open/close behavior
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.OpenDrawer, R.string.CloseDrawer);

        // Add the DrawerToggle listener to the drawer
        drawerLayout.addDrawerListener(toggle);

        // Sync the toggle state for proper drawer icon behavior
        toggle.syncState();

        // Set navigation item selection listener for the navigation view
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId(); // Get the selected item ID

                // Handle navigation item selection based on ID
                if (id==R.id.optHome){
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    loadFragment(new HomeFragment(), 1);
                } else if (id==R.id.optSettings) {
                    loadFragment(new SettingsFragment(), 1);
                } else if (id==R.id.optFeedback) {
                    loadFragment(new FeedbackFragment(), 1);
                } else if (id==R.id.optContact) {
                    loadFragment(new ContactFragment(), 1);
                } else if (id==R.id.optAbout) {
                    loadFragment(new AboutFragment(), 1);
                } else if (id==R.id.optShare) {
                    loadFragment(new ShareFragment(), 1);
                } else {
                    loadFragment(new LogoutFragment(), 1);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
                
                
            }

            public void onBackPressed() {
                // If drawer is open, close it
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // Otherwise, handle back press using the dispatcher
                    onBackPressedDispatcher.onBackPressed();
                }
            }


            // Method to handle fragment loading with add or replace behavior based on flag
            private void loadFragment(Fragment fragment, int flag) {
                FragmentManager fm = getSupportFragmentManager(); // Get the fragment manager
                FragmentTransaction ft = fm.beginTransaction(); // Begin a fragment transaction

                if (flag == 0) {
                    ft.add(R.id.container, fragment); // Add fragment to the container (assuming first use)
                } else {
                    ft.replace(R.id.container, fragment); // Replace existing fragment in the container
                }
                ft.commit(); // Commit the fragment transaction
            }
        });
    }
}
