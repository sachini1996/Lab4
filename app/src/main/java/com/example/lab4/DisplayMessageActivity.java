package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = new Intent(this, Notification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pendingIntent pendingIntent = pendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompact.Bulder builder = new
                NotificationCompact.Bulder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!")
                .setPriority(NotificationCompact.PRIORITY_DEFAULT)
                     .setContentIntent(pendingIntent)
                     .setAutoCancel(true);
        NotificationManagerCompact notificationManager =
                NotificationManagerCompact.form(this)
                notificationManager.notify(0, builder.build());
    }
}
