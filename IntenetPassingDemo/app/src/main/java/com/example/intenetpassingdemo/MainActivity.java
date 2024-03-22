package com.example.intenetpassingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Next" button by its ID
        Button btnNext = findViewById(R.id.btnNext);

        // Create an intent to navigate to the SecondActivity
        Intent iNext = new Intent(MainActivity.this, SecondActivity.class);

        // Add extra data (key-value pairs) to the intent (bundle passing)
        iNext.putExtra("title", "Intent passing using using bundle");// Key: "title", Value: "Intent passing using using bundle"
        iNext.putExtra("studentName", "Dilip"); // Key: "studentName", Value: "Dilip"
        iNext.putExtra("Roll No", 1); // Key: "Roll No", Value: 1

        // Set a click listener for the "Next" button
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SecondActivity when the button is clicked
                startActivity(iNext);
            }
        });
    }
}

//        The MainActivity class is the entry point for your Android app.
//        The onCreate method is called when the activity is created.
//        We find the “Next” button using its ID (R.id.btnNext).
//        We create an intent (iNext) to navigate to the SecondActivity.
//        When the button is clicked, we start the SecondActivity using the intent.
//        Comments have been added to explain each section of the code.
//        We add extra data (key-value pairs) to the intent using putExtra.
