package com.example.myappy;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotifyReciever extends BroadcastReceiver {

    public void buildMe(Context context) {
        // builds notifcation
        String default_notification_channel_id = "default";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,
                default_notification_channel_id);
        builder.setContentTitle("You Have a Task To Do Soon!");
        builder.setContentText("One of your tasks has an upcoming due date. Better start working on it!");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setAutoCancel(true);
        builder.setChannelId(default_notification_channel_id);
        // sets up on screen message
        makeDialogBox(context);

        // manager tells when to create notification
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());

    }

    @Override // class for reciever class
    public void onReceive(Context context, Intent intent) {

    }

    // on screen message set up
    protected void makeDialogBox(Context c) {
            //sets up dialog box
            final AlertDialog.Builder notifyDialog = new AlertDialog.Builder(c);
            notifyDialog.setTitle("YOUR TASK IS DUE SOON.\n GET TO WORK.");

            notifyDialog.setPositiveButton("Got it!", (dialog, which) -> { // if yes go here
            }).create();

            notifyDialog.setNegativeButton("No", (dialog, which) -> dialog.cancel()).create(); // if not exit
            notifyDialog.show(); // show dialog box
    }
}


