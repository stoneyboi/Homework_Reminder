package com.example.myappy;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.Calendar;

import static com.example.myappy.R.id;
import static com.example.myappy.R.layout.activity_class_view;

public class ClassView extends AppCompatActivity implements Serializable {

    // layout variables
    ListView classView;
    FloatingActionButton addIt;
    Button trashIt;
    // object variables
    Classes myClass = new Classes();
    TaskList myList = new TaskList();
    String taskName =" ";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_class_view);

        //gets data from Main Activity Class
        Intent intentO = getIntent();
        //gets ClassName for title
        taskName = intentO.getStringExtra("ClassName");
        // gets Class for setting up view
        myClass = (Classes) getIntent().getSerializableExtra("listing");
        myList = myClass.getTasksforClass(); // initializes taskList to Classes TaskList
        //sets Title on screen to specific Class name
        String Title = (taskName + " Tasks");
        TextView Name = findViewById(id.taskTitle);
        Name.setText(Title);

        // initializes variables for layout
        classView = findViewById(id.list);
        addIt = findViewById(id.floatAdd);
        trashIt = findViewById(id.floatDelete);

        // sets up adapter with data
        myListAdapter adapterList = new myListAdapter(this, myClass);
        classView.setAdapter(adapterList);
        adapterList.notifyDataSetChanged(); //updates view

        /// POSSIBLE PROBLEM SAVING IS HERE
        //sets up button to go back to Class List View
        Button backTo = findViewById(id.BtoCButton); // moves back to classes page
        backTo.setOnClickListener(v -> finish());

        //if they want to add a Task, calls function to add Tasks
        addIt.setOnClickListener(v -> {
            AddTaskInsert addPlz = new AddTaskInsert();
            addPlz.addTaskInsert(ClassView.this, myClass, adapterList);
            adapterList.notifyDataSetChanged(); // updates View at end
        });

        //sets up notification channels  for Notify Class
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // ringtone sound
            Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getApplicationContext().getPackageName() + "/" + R.raw.ringtone);  //Here is FILE_NAME is the name of file that you want to play

            // builds to sound to attribute value
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            NotificationChannel channel = new NotificationChannel("default", "Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            // enables vibration and sound during notification
            channel.enableVibration(true);
            channel.setSound(sound, attributes);

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.HOUR_OF_DAY, 12);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);

            Intent intent1 =  new Intent(getApplicationContext(), NotifyReciever.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            //repeats notification at 12pm once triggered
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

            //creates notification
            manager.createNotificationChannel(channel);
        }
    }
}