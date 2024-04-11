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

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Button btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the SharedPreferences instance named "login"
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                // Set the "flag" key to false
                editor.putBoolean("flag", false);
                editor.apply(); // Apply the changes to SharedPreferences

                Intent iLogout = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(iLogout);
            }
        });
    }
}
