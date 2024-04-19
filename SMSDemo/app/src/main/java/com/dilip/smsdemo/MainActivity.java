package com.dilip.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView txtValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValues = findViewById(R.id.txtValues);
    }

    public void updateTextView(String mobNo, String msg) {
        txtValues.setText("MobNo: " + mobNo + "\nMsg: " + msg);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Register BroadcastReceiver to listen for update intent
        IntentFilter filter = new IntentFilter("update_message"); // Matches the action set in SmsReceiver
        registerReceiver(messageReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(messageReceiver);
    }

    private BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mobNo = intent.getStringExtra("mobNo");
            String message = intent.getStringExtra("message");
            updateTextView(mobNo, message);
        }
    };
}
