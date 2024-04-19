package com.dilip.alarmmanagerdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Set a click listener for the "Set" button
        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read the time value from the EditText
                int time = Integer.parseInt(((EditText) findViewById(R.id.ediTime)).getText().toString());

                // Calculate the trigger time (current time + specified seconds)
                long triggerTime = System.currentTimeMillis() + (time * 1000);

                // Create an intent for the broadcast receiver
                Intent iBroadcast = new Intent(MainActivity.this, MyReceiver.class);

                // Create a PendingIntent for the broadcast
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ_CODE, iBroadcast, PendingIntent.FLAG_IMMUTABLE);

                // Set the alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pi);
            }
        });
    }
}
