package com.example.noitficationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Define a unique channel ID for notifications
    private static final String CHANNEL_ID = "Test Channel";
    private static final int NOTIFICATION_ID = 100;

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

        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a notification for Android Oreo (API level 26) and above
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.new_logo)
                    .setContentText("New Message")
                    .setSubText("New Message from Dilip")
                    .setChannelId(CHANNEL_ID) // Assign the channel ID
                    .build();

            // Create a notification channel (required for Android Oreo and above)
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "General", NotificationManager.IMPORTANCE_HIGH));
        } else {
            // Create a notification for older Android versions
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.new_logo)
                    .setContentText("New Message")
                    .setSubText("New Message from Dilip")
                    .build();
        }

        // Show the notification
        nm.notify(NOTIFICATION_ID, notification);
    }
}