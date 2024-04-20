package com.example.customtoolbardemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    // Declare a Toolbar variable
    Toolbar toolbar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toolbar by finding the view with the id "toolbar"
        toolbar = findViewById(R.id.toolbar);

        // Set the toolbar as the action bar for this activity
        setSupportActionBar(toolbar);

        // Check if the support action bar object is not null
        if (getSupportActionBar() != null) {
            // Enable the Up button in the toolbar
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

            // Set the title of the toolbar to "My Toolbar"
            getSupportActionBar().setTitle("My Toolbar");
        }

        // Set a custom title and subtitle directly on the toolbar object
        toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("Sub title");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu resource "opt_menu.xml" into the menu object
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.opt_new) {
            // Handle the click on the "New" menu item
            Toast.makeText(this, "Created new file", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt_open) {
            // Handle the click on the "Open" menu item
            Toast.makeText(this, "File open", Toast.LENGTH_SHORT).show();
        } else if (itemId == android.R.id.home) {
            // Handle the click on the home button (back arrow)
            super.onBackPressed();
        } else {
            // Handle clicks on other menu items (e.g., "Save")
            Toast.makeText(this, "File Save", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}


//        The onCreate method initializes the toolbar, sets its title and subtitle, and configures display options.
//        The onCreateOptionsMenu method inflates the options menu.
//        The onOptionsItemSelected method handles menu item selections (e.g., “New,” “Open,” “Save,” or home button press).