package com.dilip.audiiodemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    Button btnPlay, btnPause, btnStop, btnOnlinePlay, btnOnlinePause, btnOnlineStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);

        btnOnlinePlay = findViewById(R.id.btnOnlinePlay);
        btnOnlinePause = findViewById(R.id.btnOnlinePause);
        btnOnlineStop = findViewById(R.id.btnOnlineStop);

        MediaPlayer mp = new MediaPlayer();

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String aPath = "android.resource://"+getPackageName()+"/raw/audio";

        Uri audioUri = Uri.parse(aPath);

        try {

            mp.setDataSource(this, audioUri);
            mp.prepare();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });

        MediaPlayer op = new MediaPlayer();

        op.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String onlineAudioPath = "https://highlifeng.com.ng/swahilisongs/wp-content/uploads/2024/01/Ariana_Grande_-_7_Rings.mp3";
        Uri onlineUri = Uri.parse(onlineAudioPath);
        try {
            op.setDataSource(this, onlineUri);
            op.prepare();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnOnlinePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.start();
            }
        });

        btnOnlinePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pause();
            }
        });

        btnOnlineStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pause();
                op.seekTo(0);
            }
        });


    }
}