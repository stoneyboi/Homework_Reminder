package com.example.myappy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    @Test
    public void getDueDate() { // make sure it is set to user choice
        ClassView Example = new ClassView();

        Example.addTaskInsertManual("HW7", "HIGH", "12/28/20");

        assertEquals("12/28/20", Example.adapterList.getIteminArray(Example.tDueDate, Example.tDueDate.size() - 1));

    }
    @Test
    public void getTaskTitle() {// make sure it is set to user choice Assignment Name

    }
    @Test
    public void getPriority() {// make sure it is set to user choice

    }
    @Test
    public void getPriorityColor() { // make sure it is set to priority standards

    }
    @Test
    public void DeleteTask() {

    }
    @Test
    public void getClassTitle () {

    }
    @Test
    public void getClassDescription() {

    }
    @Test
    public void deleteClass() {

    }
    @Test
    public void addTask() {

    }
    @Test
    public void addClass() {

    }
}