package com.example.myappy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // initializes layout buttons except for delete button, delete button is in myAdapter class
    ListView listview;
    Button addButton;

    int image = (R.drawable.blackboard); // *basic* Class image of blackboard for each class

    // initializes variables
    ClassList CList = new ClassList();
    myAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializes buttons in view
        listview = findViewById(R.id.ListView);
        addButton = findViewById(R.id.button1);

        ClassList.main(CList); // initializes ClassList with Example List

        // sets up view for classlist
        adapter = new myAdapter(this, image, CList);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged(); // updates list view

        // if add button is pushed, add class function is called and passed the classList
        addButton.setOnClickListener(v -> {
            AddClass addClasshole = new AddClass();
            addClasshole.addClassInsert(MainActivity.this, CList, adapter);
            adapter.notifyDataSetInvalidated();
        });

    }

}