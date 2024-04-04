package com.dilip.customdialogboxdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a custom dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.setCancelable(false); // Prevent dialog dismissal on outside touch

        // Find the "Okay" button in the custom dialog
        Button btnOkay = dialog.findViewById(R.id.btnOkay);

        // Set a click listener for the "Okay" button
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a toast message and dismiss the dialog
                Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        // Show the custom dialog
        dialog.show();
    }
}
