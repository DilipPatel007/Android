package com.example.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textAnim;
    Button btnTranslate, btnScale, btnAlpha, btnRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textAnim = findViewById(R.id.textAnim);
        btnTranslate = findViewById(R.id.btnTranslate);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnScale = findViewById(R.id.btnScale);
        btnRotate = findViewById(R.id.btnRotate);

        // Set click listener for the Translate button
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the "move" animation from resources
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                // Start the animation on the text view
                textAnim.startAnimation(move);
            }
        });

        // Set click listener for the Alpha button
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the "alpha" animation from resources
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                // Start the animation on the text view
                textAnim.startAnimation(alpha);
            }
        });

        // Set click listener for the Rotate button
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the "rotate" animation from resources
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                // Start the animation on the text view
                textAnim.startAnimation(rotate);
            }
        });

        // Set click listener for the Scale button
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the "scale" animation from resources
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                // Start the animation on the text view
                textAnim.startAnimation(scale);
            }
        });
    }
}
