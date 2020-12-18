package com.example.myappy;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

// Called to add a Class to the Class list
public class AddClass {
    // initializes new class to add
    Classes y = new Classes();
    TaskList empty = new TaskList();

    // adds Class Name to Classes "y"
    public void addClassInsert(Context c, ClassList list, myAdapter adapter){
        // sets up dialog box and edit text line for input from the user
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
        alertDialog.setTitle("Add Class");
        final EditText input = new EditText(c.getApplicationContext());
        alertDialog.setView(input);

        // if they want to add Class, type in name and click ok
        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            String item = input.getText().toString(); // gets data from input
            adapter.rTitle.add(item);
            y.setClassName(item); // sets data as classname
            addClassDescripInsert(c, list, adapter); // calls function to add Class Description
        }).create();

        // if they dont want to add class, then exit
        alertDialog.setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel()).create();
        alertDialog.show(); // show dialog box

    }

    // adds Class Description to Classes "y"
    public void addClassDescripInsert(Context c, ClassList list, myAdapter adapter){
        // sets up dialog box and edit line for text input from user
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
        alertDialog.setTitle("Add Class Description");
        final EditText input = new EditText(c.getApplicationContext());
        alertDialog.setView(input);

        // if they want to add class description, add descrip string then click ok
        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            String descrip = input.getText().toString(); // gets data from user
            y.setClassDescrip(descrip); // sets Class Description in Classes "y"
            TaskList.setEmpty(empty); // sets list to empty task list
            y.setTasksforClass(empty); // sets list to empty task list
            // adds to array of Class names
            adapter.rDesc.add(descrip); // view and class are separate when adding and deleting tasks or classes
            list.addClass(y); // at this point the class Task list should be empty still and initialized to nothing
            adapter.notifyDataSetChanged(); //  update view since data set changes
            // on screen message to show at bottom that class was added
            Toast.makeText(c.getApplicationContext(), "Class Added", Toast.LENGTH_LONG).show();
        }).create();

        // if they dont want to add the class AT ALL, data is there but not added to list,
        // clicking CANCEL will exit dialog prompts
        alertDialog.setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel()).create();
        alertDialog.show(); // show dialog box on screen with options
    }
}
