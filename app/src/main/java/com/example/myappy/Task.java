package com.example.myappy;


import java.io.Serializable;

//object Class for Tasks
public class Task implements Serializable {
    //declares local Variables
        private String assignmentName;
        private String priority;
        private String dueDate;

        // instantiates new Task with Empty variables
        public Task (){
            assignmentName = " ";
            priority = " ";
            dueDate = " ";
        }

        // sets variables to desired data given
        public Task(String name, String date, String pri){
            assignmentName = name;
            priority = pri;
            dueDate = date;
        }

        // gettters and setters for local variables
        public String getAssignmentName() {
            return assignmentName;
        }

        public void setAssignmentName(String assignmentName) {
            this.assignmentName = assignmentName;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

//end of Class
}
