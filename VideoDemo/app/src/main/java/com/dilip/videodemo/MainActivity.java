package com.dilip.videodemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the VideoView
        videoView = findViewById(R.id.videoView);

        // Set the path for the local video resource
        String vPath = "android.resource://" + getPackageName() + "/raw/video";
        Uri videoUri = Uri.parse(vPath);

        // Set the video URI and start playback
        videoView.setVideoURI(videoUri);
        videoView.start();

        // Create a media controller for playback controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Create an intent for launching the SecondActivity
        Intent iNext = new Intent(MainActivity.this, SecondActivity.class);

        // Set a click listener for the "Online" button
        Button btnOnline = findViewById(R.id.btnOnline);
        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNext);
            }
        });
    }
}
