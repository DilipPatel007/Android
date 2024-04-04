package com.example.tablayoutdemo;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    // Declare member variables for the TabLayout and ViewPager
    private TabLayout tab;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TabLayout and ViewPager views by their IDs in the layout
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        // Create an adapter for the ViewPager with the FragmentManager
        ViewPagerMessengerAdapter adapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager to handle tab selection and fragment changes
        tab.setupWithViewPager(viewPager);
    }
}
