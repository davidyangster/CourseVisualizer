package com.example.todolist;

import com.example.todolist.data.model.Assignment;
import com.example.todolist.data.model.Course;
import com.example.todolist.data.model.MyGrades;
import com.example.todolist.data.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //----------should be initialized and loaded when app opens////
    public static List<Profile> profiles = new ArrayList<>();
    //load();



    public static Profile currentProfile = null;
    public static MyGrades myGrades = null;
    //somewhere inside the listofcourses page
    public static String currentCourseName = null;


    public void load() {
    }

    //////BUTTONS////////



    //it checks if assignments in a course add up to 100
    //if it does, adds the list of assignments to the course, if not, throws error
    //handle if suddenly exits app--->> should remove ALL elements from
    //or alternatively save ONLY after it adds up to 100
    public void buttonAddAssignments() {
        //pass in current name to get the course


        if (count100()) {
            //throw exception/alert box
        }
        //if they choose to cancel/delete then
        //currentProfile.getCourse(currentCourseName).getCourseAssignments().clear();

    }

    public void buttonAddAssignment(String name, int weight) {
        Course course = currentProfile.getCourse(currentCourseName);
        course.addCourseAssignment(new Assignment(name, weight));
    }

    public void loginButtonPressed(String userName, String password) {
        if(verifyCredentials(userName,password)) {
            //next page
        } else {
            //alertbox --> wrong password
        }
    }

    private boolean verifyCredentials(String userName, String password) {
        return  (userName == "xx" && password == "yy");
    }


    public boolean count100() {
        List<Assignment> currAssignments = currentProfile.getCourse(currentCourseName).getCourseAssignments();
        int count = 0;
        for(Assignment a : currAssignments) {
            count = count + a.getAssignmentWeight();
        }
        return count == 100;
    }

    public void addCourseButtonPressed(String courseName) {
        currentProfile.addCourse(new Course(courseName));
    }

    public void clickAnyCourse(String courseName) {
        currentCourseName = courseName;

        //should go to the new page
        //--->>>> the CourseBreakdown page
        //currentProfile.getCourse(currentCourseName).getCourseAssignments();
    }

    public void pieChartButton() {
        if(count100()) {
            //Show pie chart
        } else {
            //alertBOX
        }

    }

    public void logoutButtonPressed() {
        save();
        // ----> redirect to login screen
    }



    public void signUpButton(String userName, String password) {
        currentProfile = new Profile(userName, password);
        if (!profiles.contains(currentProfile)) {
            profiles.add(currentProfile);
        } else {
            currentProfile = null;
            ///ALERTBOX here saying "profile already exist"
        }
    }

    public void save() {
    }

    ///////////nexgt steps---> my grades---->>>>////
    public void myGradesSideBarButton() {
        myGrades = new MyGrades();
        //////New page consisting of labels with answerBoxes for them to input their percentages
    }

    public void myPercentagesButton() {
        myGrades.calculatedWeights()
        //////piechart show here

    }



}
