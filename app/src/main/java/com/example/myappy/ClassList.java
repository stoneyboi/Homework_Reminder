package com.example.myappy;

import java.util.ArrayList;

// Object Class for array of Classes
public class ClassList {
    //declares local variables
    protected ArrayList<Classes> ClassList;
    private int size;

    //returns a class from list
    public Classes get(int i){
        return ClassList.get(i);
    }

    //instantiates ClassList to empty variables
    public ClassList(){
        super();
        this.ClassList  = new ArrayList<>();
        this.size = 0;
    }

    //getters and setters for local variables
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Classes> getList() {
        return ClassList;
    }

    public void setList(ArrayList<Classes> list) {
        this.ClassList = list;
    }

    //adds Class to ClassList WITH EMPTY VARIABLES STILL NEEDING TO BE SET
    public void addClass(Classes myClass){
        ClassList.add(myClass);
        size++;
    }

    //Removes Class AND GETS RIDS OF TASKLIST FOR CLASS
    public void removeClass(Classes myClass){
        ClassList.remove(myClass);
        size--;
    }

    // sets up Class List with Example Classes in to a List
    public static void main(ClassList cList){
        //initializes example TaskLists for classes
        // uses two different example lists to show different tasks in each class
        TaskList list = new TaskList();
        TaskList list2 = new TaskList();
        TaskList.main(list);
        TaskList.main2(list2);

        Classes a = new Classes("CIS 350", "Description for 350", list);
        Classes b = new Classes("CIS 241", "Description for 241", list2);
        Classes c = new Classes("CIS 353", "Description for 353", list);
        Classes d = new Classes("CIS 290", "Description for 290", list2);
        Classes e = new Classes("MTH 325", "Description for 325", list);

        cList.addClass(a);
        cList.addClass(b);
        cList.addClass(c);
        cList.addClass(d);
        cList.addClass(e);
    }


}
