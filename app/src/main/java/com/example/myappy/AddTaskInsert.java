package com.example.myappy;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;


public class AddTaskInsert {

    Task x = new Task(); // creates a new task to insert

    // adds name to task
    public void addTaskInsert(Context c, Classes cls, myListAdapter adapterList){
        // sets up dialog box and edit text input from user
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
        alertDialog.setTitle("Add Task Name");
        final EditText input = new EditText(c.getApplicationContext());
        alertDialog.setView(input);

        alertDialog.setPositiveButton("OK", (dialog, which) -> { // if they want to add a task go here
            String item = input.getText().toString(); // gets data from user
            adapterList.hTitle.add(item); // adds to array list for view
            x.setAssignmentName(item); // sets Task name
            addTaskPriorityInsert(c, cls, adapterList); // calls add priority function
        }).create();

        alertDialog.setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel()).create(); // if not, exit dialog window
        alertDialog.show(); // show dialog box
    }

    // adds priority level to task
    protected void addTaskPriorityInsert(Context c, Classes cls, myListAdapter adapterList){
        //sets up dialog box and text input
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
        alertDialog.setTitle("Add Priority");
        final EditText input = new EditText(c.getApplicationContext());
        alertDialog.setView(input);

        alertDialog.setPositiveButton("OK", (dialog, which) -> { // if they want to add task priority go here
            String item = input.getText().toString().toUpperCase(); // gets user input and sets it to all uppercase to look *pretty*
            x.setPriority(item); // sets priority for function
            adapterList.hPriority.add(item); // adds to arraylist for view
            addTaskDueInsert(c, cls, adapterList); // calls function to set due date
        }).create();

        alertDialog.setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel()).create(); // if not, exit
        alertDialog.show(); // show dialog box
    }

    // adds due date to task
    protected void addTaskDueInsert(Context c, Classes cls, myListAdapter adapterList){
        // sets up dialog box and text input
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
        alertDialog.setTitle("Add Due Date");
        final EditText input = new EditText(c.getApplicationContext());
        alertDialog.setView(input);

        TaskList y;
        y = cls.getTasksforClass();
        alertDialog.setPositiveButton("OK", (dialog, which) -> { // if they want to add task, go here
            String item = input.getText().toString(); //gets inputted data from user
            x.setDueDate(item); // sets due Date
            adapterList.hDuedate.add(item); // adds to arraylist for view
            cls.getTasksforClass().addTask(x); // adds task to list
            toNotifyOrNot(c); // calls function to see if they want a notification
            adapterList.notifyDataSetChanged(); // tells adapter to change views
            Toast.makeText(c.getApplicationContext(), "Task Added", Toast.LENGTH_LONG).show(); // on screen message
        }).create();

        alertDialog.setNegativeButton("CANCEL", (dialog, which) -> dialog.cancel()).create(); // if not exit
        alertDialog.show();

    }

    // adds notification to task
    protected void toNotifyOrNot(Context c) {
        //sets up dialog box
        final AlertDialog.Builder notifyDialog = new AlertDialog.Builder(c);
        notifyDialog.setTitle("Do you wish to be notified earlier of this task?");


        notifyDialog.setPositiveButton("Yes", (dialog, which) -> { // if yes go here
            NotifyReciever note = new NotifyReciever(); //calls notification function
            note.buildMe(c);
        }).create();

        notifyDialog.setNegativeButton("No", (dialog, which) -> dialog.cancel()).create(); // if not exit
        notifyDialog.show(); // show dialog box
    }
}
