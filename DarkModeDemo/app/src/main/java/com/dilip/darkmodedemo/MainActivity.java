package com.dilip.darkmodedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {
    Switch switcher;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the switcher (UI element)
        switcher = findViewById(R.id.switcher);

        // Get the saved night mode preference
        sharedPreferences = getSharedPreferences("MODE", MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("night", false); // Light mode is the default

        // Set the switcher state based on the saved preference
        if (nightMode) {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        // Set a click listener for the switcher
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle night mode and update the shared preference
                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply(); // Apply the changes to SharedPreferences
            }
        });
    }
}



//        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
//    }
//
//    public void NightModeON(View view){
//        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
//    }
//
//    public void NightModeOFF(View view){
//        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
//    }