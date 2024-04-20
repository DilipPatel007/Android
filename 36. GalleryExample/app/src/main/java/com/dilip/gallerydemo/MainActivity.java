package com.dilip.gallerydemo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgGallery; // ImageView to display the captured image
    Button btnGallery; // Button to launch the camera
    public final int GALLERY_REQ_CODE = 1; // Request code for gallery activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imgGallery = findViewById(R.id.imgGallery); // ImageView for displaying the captured image
        btnGallery = findViewById(R.id.btnGallery); // Button to launch the gallery

        // Set click listener for the gallery button
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the gallery app
                Intent iGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE); // Start the gallery activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                // Handle the result from the gallery activity
                // The selected image URI is stored in the "data" extras bundle
                imgGallery.setImageURI(data.getData()); // Display the selected image in the ImageView
            }
        }
    }
}
