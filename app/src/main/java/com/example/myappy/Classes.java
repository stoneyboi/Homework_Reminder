package com.example.myappy;

import java.io.Serializable;

// Object Class for Classes
public class Classes implements Serializable{
    // declares local variables
    private String ClassName;
    private String ClassDescrip;
    private TaskList TasksforClass;

    //sets variables to empty
    public Classes(){
        ClassName = " ";
        ClassDescrip = " ";
        TasksforClass = new TaskList();
    }

    // sets variables for a class to input
    public Classes(String ClassName, String ClassDescripton, TaskList ClassTasks) {
        this.ClassName = ClassName;
        this.ClassDescrip = ClassDescripton;
        this.TasksforClass = ClassTasks;
    }

    // getters and setters for variables
    public String getClassDescrip() {return ClassDescrip; }

    public void setClassDescrip(String desc) { this.ClassDescrip = desc; }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        this.ClassName = className;
    }

    public TaskList getTasksforClass() { return TasksforClass; }

    public void setTasksforClass(TaskList list) { this.TasksforClass = list; }
}
