package com.dilip.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    // Declare a MediaPlayer instance
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // Return null as this service does not support binding
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Create a MediaPlayer with the default alarm alert sound
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mp.setLooping(true); // Set looping to true for continuous playback
        mp.start(); // Start playing the audio
        return START_NOT_STICKY; // Service will not be restarted if killed by the system
    }

    @Override
    public void onDestroy() {
        // Stop and release the MediaPlayer when the service is destroyed
        mp.stop();
        mp.release();
        super.onDestroy();
    }
}
