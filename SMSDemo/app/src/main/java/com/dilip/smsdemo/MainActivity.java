package com.dilip.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> messageList;
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.message_list); // Replace with your ListView ID
        messageList = new ArrayList<>();
        adapter = new MyListAdapter(this, messageList); // Create and set adapter
        listView.setAdapter(adapter);
    }

    public void updateMessageList(String mobNo, String msg) {
        String message = "MobNo: " + mobNo + "\nMsg: " + msg;
        messageList.add(message); // Add message to the list
        adapter.notifyDataSetChanged(); // Notify adapter about data change
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Register BroadcastReceiver to listen for update intent
        IntentFilter filter = new IntentFilter("update_message");
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
            updateMessageList(mobNo, message);
        }
    };
}
