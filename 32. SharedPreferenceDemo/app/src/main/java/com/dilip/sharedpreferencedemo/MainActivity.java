package com.dilip.sharedpreferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Delay execution using a Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Get the SharedPreferences instance named "login"
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag", false);

                Intent iNext;
                if (check) {  // If flag is true, user is logged in
                    iNext = new Intent(MainActivity.this, HomeActivity.class);
                } else { // If flag is not set (default value used), user is logged out
                    iNext = new Intent(MainActivity.this, LoginActivity.class);
                }
                startActivity(iNext);
            }
        }, 2000); // 3 seconds delay
    }
}
