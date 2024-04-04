package com.dilip.alertdialogboxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//        // Create an AlertDialog using the AlertDialog.Builder class
//
//        // Set the title for the alert dialog
//        alertDialog.setTitle("Terms & Conditions");
//
//        // Set the icon for the alert dialog
//        alertDialog.setIcon(R.drawable.baseline_info_24);
//
//        // Set the message to be displayed in the alert dialog
//        alertDialog.setMessage("Have you read all Terms & Conditions?");
//
//        // Set a button with a custom label and click listener
//        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes, I've Read", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You can proceed now...", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // Show the alert dialog
//        alertDialog.show();
//    }

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and show the dialog first
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Terms & Conditions")
                .setIcon(R.drawable.baseline_info_24)
                .setMessage("Have you read all Terms & Conditions?")
                .setPositiveButton("Yes, I've Read", null)  // Set to null for now
                .create();
        alertDialog.show();

        // Set the positive button's listener after showing the dialog
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you can proceed now..", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        // Move Button code (for moving on button click)
        Button moveButton = findViewById(R.id.btnMove);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}


