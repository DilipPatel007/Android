package com.dilip.alarmmanagerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyReceiver extends BroadcastReceiver {

    // Declare a MediaPlayer instance
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Create a MediaPlayer with the default ringtone URI
        mp = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mp.setLooping(true); // Set looping to true for continuous playback
        mp.start(); // Start playing the ringtone
    }
}
