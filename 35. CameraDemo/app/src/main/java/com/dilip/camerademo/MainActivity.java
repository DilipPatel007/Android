package com.dilip.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView imgCamera; // ImageView to display the captured image
    Button btnCamera; // Button to launch the camera
    public final int CAMERA_REQ_CODE = 1; // Request code for camera activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imgCamera = findViewById(R.id.imgCamera); // ImageView for displaying the captured image
        btnCamera = findViewById(R.id.btnCamera); // Button to launch the camera

        // Set click listener for the camera button
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the camera app
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera, CAMERA_REQ_CODE); // Start the camera activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            // Handle the result from the camera activity
            // The captured image is stored in the "data" extras bundle
            Bitmap img = (Bitmap) (data.getExtras().get("data"));
            imgCamera.setImageBitmap(img); // Display the captured image in the ImageView
        }
    }
}
