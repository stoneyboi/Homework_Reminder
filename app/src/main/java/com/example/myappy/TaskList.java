package com.example.myappy;


import android.os.Build;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
// object Class for arrayList of Tasks
public class TaskList implements Serializable {
    //declares variables
    protected ArrayList<Task> list;
    private int size;
    protected static final int TASKNAME = 1;
    protected static final int PRIORITY = 2;
    protected static final int DUEDATE = 3;
    protected int sorting;

    // returns local variable of a Task in a List
    public String getValueAt(int row, int col){
        return taskScreen(row, col);
    }

    public String taskScreen(int row, int col){
        switch (col) {
            case 0:
                return (list.get(row).getAssignmentName());

            case 2:
                return (list.get(row).getDueDate());

            case 3:
                return (list.get(row).getPriority());

            default:
                throw new RuntimeException("JTable row, col is out of range" + row + " " + col);
        }

    }
    // updates list to sort by variable
    public void Update(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        switch (sorting) {

            case TASKNAME:
                list = (ArrayList<Task>) list.stream().filter(n -> n.getAssignmentName() != null).collect(Collectors.toList());
                Collections.sort(list, ((a1, a2) -> a1.getAssignmentName().compareToIgnoreCase(a2.getAssignmentName())));
                break;
            case PRIORITY:
                list = (ArrayList<Task>) list.stream().filter(n -> n.getAssignmentName() != null).collect(Collectors.toList());
                Collections.sort(list, ((a1, a2) -> a1.getPriority().compareToIgnoreCase(a2.getPriority())));
                break;
            case DUEDATE:
                list = (ArrayList<Task>) list.stream().filter(n -> n.getAssignmentName() != null).collect(Collectors.toList());
                Collections.sort(list, ((a1, a2) -> a1.getDueDate().compareTo(a2.getDueDate())));
                break;
        }
        }

    }

        //sets sorting variable for update function
    public void setSorting(int selected){
        sorting = selected;
        Update();
    }

    //returns Task when called
    public Task get(int i){
        return list.get(i);
    }

    // instantiates new TaskList to empty variables
    public TaskList(){
        super();
        this.list  = new ArrayList<>();
        this.size = 0;
    }

    // getters and setters for variables
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void setList(ArrayList<Task> list) {
        this.list = list;
    }

    // adds task to TaskList
    public void addTask(Task task){
        list.add(task);
        size++;
    }

    //removes Task from TaskList
    public void removeTask(Task task){
        list.remove(task);
        size--;
    }

    // sets up lists with example TaskLists
    public static void main(TaskList list){

        Task x = new Task("HW5 1", "20201510", "HIGH");
        Task y = new Task("HW3 1", "20201512", "MEDIUM");
        Task z = new Task("Test1", "20201510", "HIGH");
        Task a = new Task("Quiz1", "20201511", "LOW");
        Task b = new Task("HW1 Test", "20201212", "MEDIUM");
        Task c = new Task("HW1 Test1", "20201212", "NONE");
        Task d = new Task("HW1 Test2", "20201212", "HIGH");
        Task e = new Task("HW1 Test3", "20201212", "LOW");

        list.addTask(x);
        list.addTask(y);
        list.addTask(z);
        list.addTask(a);
        list.addTask(b);
        list.addTask(c);
        list.addTask(d);
        list.addTask(e);
    }

    // sets up list with Example TaskList with different values
    public static void main2(TaskList list) {

        Task x = new Task("HW5 2", "20201510", "HIGH");
        Task y = new Task("HW3 2", "20201512", "MEDIUM");
        Task z = new Task("Test2", "20201510", "HIGH");
        Task a = new Task("Quiz2", "20211511", "LOW");
        Task b = new Task("HW2 Test", "20201212", "MEDIUM");
        Task c = new Task("HW2 Test1", "20201222", "NONE");
        Task d = new Task("HW2 Test2", "20211212", "HIGH");
        Task e = new Task("HW2 Test3", "20201212", "LOW");

        list.addTask(x);
        list.addTask(y);
        list.addTask(z);
        list.addTask(a);
        list.addTask(b);
        list.addTask(c);
        list.addTask(d);
        list.addTask(e);
    }

    public static void setEmpty(TaskList list){

        Task empty = new Task();
        list.addTask(empty);
    }

}