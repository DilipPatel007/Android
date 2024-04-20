package com.dilip.videodemo;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize the VideoView for online video playback
        VideoView videoView = findViewById(R.id.onlineVideoView);

        // Set the path for the online video resource
        String onlinePath = "https://file-examples.com/storage/fef545ae0b661d470abe676/2017/04/file_example_MP4_480_1_5MG.mp4";
        Uri onlineVideoUri = Uri.parse(onlinePath);

        // Set the video URI and start playback
        videoView.setVideoURI(onlineVideoUri);
        videoView.start();

        // Create a media controller for playback controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
