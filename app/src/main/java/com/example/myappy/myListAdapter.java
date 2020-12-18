package com.example.myappy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.myappy.R.id.DueDateA;
import static com.example.myappy.R.id.NameA;
import static com.example.myappy.R.id.PriorityA;

// adapter class to set up taskList View on layout
public class myListAdapter extends BaseAdapter implements ListAdapter {

    //initial variables used
    Context context;
    protected ArrayList<String> hTitle = new ArrayList<>();
    protected ArrayList<String> hPriority = new ArrayList<>();
    protected ArrayList<String> hDuedate = new ArrayList<>();
    protected Classes ClassCurrent;
    protected TaskList Tlist;


    public myListAdapter(Context c, Classes list) {
        //intializes data
        super();
        this.context = c;
        this.ClassCurrent = list;
        Tlist = ClassCurrent.getTasksforClass();
        //sorts by priority for all tasks
        Tlist.setSorting(TaskList.PRIORITY);
        Tlist.Update(); // updates list

        // gets taskList variables and sets them into arrays to put into view
        getTasks(Tlist);

    }

    //Adds Tasks to ArrayLists for view
    protected void getTasks(TaskList list){
        for(int i =0; i < list.getSize(); i++) { // goes through whole list
                hTitle.add(list.getValueAt(i, 0)); // getAssignmentName function
                hPriority.add(list.getValueAt(i, 3)); //getPriority function
                hDuedate.add(list.getValueAt(i, 2)); //getDuedate function
        }
    }

    @Override // classes that come with adapter
    public int getCount() {

        return hTitle.size();
    }

    @Override // classes that come with adapter
    public Object getItem(int position) {
        return null;
    }


    @Override // classes that come with adapter
    public long getItemId(int pos) {

        return pos;
    }

    @NonNull
    @Override // sets tasks in a view
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.class_rows, parent, false);

        // sets textviews in layout to element in array
        TextView Name = row.findViewById(NameA);
        TextView Priority = row.findViewById(PriorityA);
        TextView DueDate = row.findViewById(DueDateA);

        // sets textviews in layout to element in array
        if(position < hTitle.size()) {
            Name.setText(hTitle.get(position));
            Priority.setText(hPriority.get(position));
            if (Priority.getText().toString().equals("HIGH")) { // sets color of text for priority
                Priority.setTextColor(Color.RED); // red for HIGH priority
            } else {
                // orange for MEDIUM priority
                if (Priority.getText().toString().equals("MEDIUM")) {
                    Priority.setTextColor(Color.parseColor("#FFFF9800")); // Orange
                } else { // LOW or anything else gets set to not important
                    Priority.setTextColor(Color.GREEN);
                }
            }
            DueDate.setText(hDuedate.get(position));
        }

        // initializes button to delete for each class and calls necessary function
        Button delete = row.findViewById((R.id.floatDelete));
        delete.setOnClickListener(v -> { // if delete button is clicked, all data in row is deleted
            //listing.get(position) returns Task which is then removed
            hDuedate.remove(position); // removes from view
            hTitle.remove(position); // removes from view
            hPriority.remove(position); // removes from view

            Tlist.removeTask(Tlist.get(position)); // removes from TaskList
            ClassCurrent.setTasksforClass(Tlist); // updates Task List with new TaskList

            notifyDataSetChanged(); // update the view since a task was deleted
        });

        notifyDataSetChanged(); // updates view no matter what
        return row;
    }
}
