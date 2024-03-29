package com.example.alertdialogboxdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button actionButton = findViewById(R.id.btnClick);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the action confirmation dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setTitle("Action")
                        .setMessage("What do you want to do?")
                        .setPositiveButton("Exit App", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                System.exit(0); //  kill the current process and remove the activity from the back stack (in this case SecondActivity) and it will also resume the activity that it’s below on the stack
                                finishAffinity();
                            }
                        })
                        .setNeutralButton("Go Back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Go back to the previous activity (MainActivity)
                                finish();  // Finishes current activity (SecondActivity)
                            }
                        })
                        .setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dismiss the dialog if user wants to stay
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });

    }
}


