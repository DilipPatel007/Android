package com.example.implicitintentdemo;

import android.content.Intent;
import android.net.Uri;
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

        Button btnSendEmail, btnDial, btnMsg, btnShare, btnOpenMaps;

        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnShare = findViewById(R.id.btnShare);
        btnOpenMaps = findViewById(R.id.btnOpenMaps);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMail = new Intent(Intent.ACTION_SEND);
                iMail.setType("message/rfc822");
                iMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com", "example@gmail.com"});
                iMail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iMail.putExtra(Intent.EXTRA_TEXT, "Resolve this issue");
                startActivity(Intent.createChooser(iMail, "Email via"));
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent();
                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +911234567890"));
                startActivity(iDial);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+911234567890")));
                iMsg.putExtra("sms_body", "Hi, How are you?");
                startActivity(iMsg);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to share text
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome app!");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        btnOpenMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double latitude = 37.4220; // Example latitude
//                double longitude = -122.0841; // Example longitud
//                Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);

                // Open Google Maps (you can customize the location)
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Googleplex, Mountain View, CA");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
//                if (mapIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(mapIntent);
//                } else {
//                    // Handle the case where Google Maps is not installed
//                    Toast.makeText(MainActivity.this, "Google Maps not installed", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }
}



