package com.example.noitficationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


public class MainActivity extends AppCompatActivity {

    // Define a unique channel ID for notifications
    private static final String CHANNEL_ID = "Test Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the drawable resource for the large icon
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.new_logo, null);

        // Convert the drawable to a Bitmap
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        // Get the NotificationManager service
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create an Intent to launch the MainActivity when the notification is clicked
        Intent iNotify = new Intent(getApplicationContext(), MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE, iNotify, PendingIntent.FLAG_IMMUTABLE);
        // A PendingIntent in Android is a token that you give to another application or the Android system to perform an action on your behalf.
        // A PendingIntent allows you to delegate an action to be performed in the future, even if your application is not running.

//        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE, iNotify, PendingIntent.FLAG_UPDATE_CURRENT);
//        The error message indicates an issue with PendingIntent creation on devices running Android API level 31 (Android 12) and above.
//        It states that either FLAG_IMMUTABLE or FLAG_MUTABLE must be specified for security reasons.

        // Create the BigPictureStyle notification content
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(largeIcon) // Set the large image
                .bigLargeIcon(largeIcon) // Set the large icon (optional)
                .setBigContentTitle("Image sent by Dilip")
                .setSummaryText("Text Message");

        // Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("J")
                .addLine("K")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Dilip");


        // Create the notification
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a notification for Android Oreo (API level 26) and above
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.new_logo)
                    .setContentText("New Message")
                    .setSubText("New Message from Dilip")
                    .setOngoing(true)
                    .setStyle(bigPictureStyle)
                    .setContentIntent(pi)
                    .setChannelId(CHANNEL_ID) // Assign the channel ID
                    .build();

            // Create a notification channel (required for Android Oreo and above)
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "General", NotificationManager.IMPORTANCE_HIGH));

        } else {
            // Create a notification for older Android versions (similar to above)
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.new_logo)
                    .setContentText("New Message")
                    .setSubText("New Message from Dilip")
                    .setAutoCancel(true)
                    .setStyle(bigPictureStyle)
                    .setContentIntent(pi)
                    .build();
        }

        // Find the button by its ID
        Button btnAction = findViewById(R.id.btnAction);

        // Set onClickListener for the button to show the notification
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(NOTIFICATION_ID, notification);
            }
        });

    }
}
