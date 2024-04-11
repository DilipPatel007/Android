package com.dilip.sharedpreferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Set padding for system bars (status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the login button by its ID
        Button btnLogin = findViewById(R.id.btnLogin);

        // Set a click listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the SharedPreferences instance named "login"
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                // Set the "flag" key to true (user is logged in)
                editor.putBoolean("flag", true);
                editor.apply(); // Apply the changes to SharedPreferences

                // Start the HomeActivity
                Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(iHome);
            }
        });
    }
}
