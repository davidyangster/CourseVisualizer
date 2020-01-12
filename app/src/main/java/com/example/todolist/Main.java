package com.example.todolist;


import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.todolist.data.model.Assignment;
import com.example.todolist.data.model.Course;
import com.example.todolist.data.model.MyGrades;
import com.example.todolist.data.model.Profile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //----------should be initialized and loaded when app opens////
    public static List<Profile> profiles = new ArrayList<>();
    //load();

    ////for(i


    public static Profile currentProfile = null;
    public static MyGrades myGrades = null;
    //somewhere inside the listofcourses page
    public static String currentCourseName = null;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/outputs.txt"));
        int i = 0;

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            ArrayList<Course> tempCourses = new ArrayList<>();
            ArrayList<Assignment> tempAssignments = new ArrayList<>();

            Profile profile = new Profile(partsOfLine.get(0), partsOfLine.get(1));

            for (String part : partsOfLine) {

                String tempAssignmentName = "";
                String tempAssignmentWeight = "";
                Course tempCourse = null;

                if (part.startsWith("+")) {
                    tempCourse = new Course(part.substring(1));
                    tempCourses.add(tempCourse);


                } else if (part.startsWith("!")) {
                    tempAssignmentName = part.substring(1);

                } else if (part.startsWith("%")) {
                    tempAssignmentWeight = part.substring(1);
                    if(part.endsWith("endOfString")) {
                        tempAssignmentWeight = part.substring(1, part.length() - 11);
                    }
                }
                i++;
                if (i%2 == 0) {
                    tempAssignments.add(new Assignment(tempAssignmentName, Integer.parseInt(tempAssignmentWeight)));
                    tempCourse.setCourseAssignments(tempAssignments);
                }
            }

            profile.setCourses(tempCourses);

        }


//        JSONObject employeeDetails = new JSONObject();
//        for (Profile profile : profiles) {
//            JSONObject profileJSON = new JSONObject();
//            profileJSON.put("userName", profile.getUserName());
//            profileJSON.put("password", profile.getPassword());
//            profileJSON.put("courses", profile.getCourses());
//            for (Course course : profile.getCourses()) {
//                for (Assignment assignment : course.getCourseAssignments()) {
//
//                }
//
//
//                employeeDetails.put(profile., "Lokesh");
//                employeeDetails.put("lastName", "Gupta");
//                employeeDetails.put("website", "howtodoinjava.com");
//
//                JSONObject employeeObject = new JSONObject();
//                employeeObject.put("employee", employeeDetails);

//            }
//        }

    }

    // EFFECTS: saves items from this todolist to text file

    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("./data/outputs.txt", "UTF-8");
        ArrayList<String> infoString = new ArrayList<>();

        for (Profile profile : profiles) {
            List<Course> tempCourseList = profile.getCourses();
            infoString.add(profile.getUserName() + " " + profile.getPassword() + " ");
            for (Course course : tempCourseList) {
                List<Assignment> tempAssignmentList = course.getCourseAssignments();
                infoString.add("+" + course.getCourseName() + " ");
                for(Assignment assignment : tempAssignmentList) {
                    infoString.add("!"+ assignment.getAssignmentName() + " " + "%" +assignment.getAssignmentWeight());
                }
            }
        }
        infoString.add("endOfFile");

        for (String line : infoString) {
            writer.println(line);
        }
        writer.close();

    }

        ///BUTTONS///


        //it checks if assignments in a course add up to 100
        //if it does, adds the list of assignments to the course, if not, throws error
        //handle if suddenly exits app--->> should remove ALL elements from
        //or alternatively save ONLY after it adds up to 100
        public void buttonAddAssignments () {
            //pass in current name to get the course


            if (count100()) {
                //throw exception/alert box
            }
            //if they choose to cancel/delete then
            //currentProfile.getCourse(currentCourseName).getCourseAssignments().clear();

        }

        public void buttonAddAssignment (String name,int weight){
            Course course = currentProfile.getCourse(currentCourseName);
            course.addCourseAssignment(new Assignment(name, weight));
        }

        public void loginButtonPressed (String userName, String password){
            if (verifyCredentials(userName, password)) {
                //next page
            } else {
                //alertbox --> wrong password
            }
        }

        private boolean verifyCredentials (String userName, String password){
            return (userName == "xx" && password == "yy");
        }


        public boolean count100 () {
            List<Assignment> currAssignments = currentProfile.getCourse(currentCourseName).getCourseAssignments();
            int count = 0;
            for (Assignment a : currAssignments) {
                count = count + a.getAssignmentWeight();
            }
            return count == 100;
        }

        public void addCourseButtonPressed (String courseName){
            currentProfile.addCourse(new Course(courseName));
        }

        public void clickAnyCourse (String courseName){
            currentCourseName = courseName;

            //should go to the new page
            //--->>>> the CourseBreakdown page
            //currentProfile.getCourse(currentCourseName).getCourseAssignments();
        }

        public void pieChartButton () {
            if (count100()) {
                //Show pie chart
            } else {
                //alertBOX
            }

        }

        public void logoutButtonPressed () throws FileNotFoundException, UnsupportedEncodingException {
            save();
            // ----> redirect to login screen
        }


        public void signUpButton (String userName, String password){
            currentProfile = new Profile(userName, password);
            if (!profiles.contains(currentProfile)) {
                profiles.add(currentProfile);
            } else {
                currentProfile = null;
                ///ALERTBOX here saying "profile already exist"
            }
        }



        ///////////nexgt steps---> my grades---->>>>////
        public void myGradesSideBarButton () {
            myGrades = new MyGrades();
            //////New page consisting of labels with answerBoxes for them to input their percentages
        }

        public void myPercentagesButton () {
            myGrades.calculatedWeights();
            //////piechart show here
        }

    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    }

