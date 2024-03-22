package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create an intent to navigate to the MainActivity
        Intent iHome = new Intent(SplashActivity.this, MainActivity.class);

        // Delay the start of MainActivity by 4 seconds (4000 milliseconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the MainActivity after the delay
                startActivity(iHome);
                finish(); // Close the SplashActivity to prevent going back to it
            }
        }, 4000); // 4000 milliseconds = 4 seconds
    }
}


//        The SplashActivity class is typically used for displaying a splash screen or loading screen when the app starts.
//        In the onCreate method:
//        We create an intent (iHome) to navigate to the MainActivity.
//        We use a Handler to delay the start of the MainActivity by 4 seconds (4000 milliseconds).
//        After the delay, we start the MainActivity.