package com.example.customtoastdemo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, "Default Toast", Toast.LENGTH_SHORT).show();

       // Find the button with the id "btnToast"
        Button btnToast = findViewById(R.id.btnToast);

        // Set an onClickListener for the button
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Toast instance
                Toast toast = new Toast(getApplicationContext());

                // Inflate the custom toast layout from "custom_toast_layout.xml"
                View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));

                // Set the custom layout view to the Toast
                toast.setView(view);

                // Find the TextView with the id "txtMsg" within the custom layout
                TextView txtMsg = view.findViewById(R.id.txtMsg);

                // Set the text of the TextView to "Message sent successfully"
                txtMsg.setText("Message sent successfully");

                // Set the duration of the Toast to SHORT
                toast.setDuration(Toast.LENGTH_SHORT);

                toast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);

                // Show the custom Toast
                toast.show();
            }
        });
    }
}