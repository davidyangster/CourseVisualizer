package com.example.todolist.data.model;

import java.util.List;

import static com.example.todolist.Main.currentCourseName;
import static com.example.todolist.Main.currentProfile;

public class MyGrades {
    public Course course;
    public double gradesLost = 0;
    public List<Assignment> assignmentWeights;

    public MyGrades () {
        this.course = currentProfile.getCourse(currentCourseName);
        this.assignmentWeights = course.getCourseAssignments();
    }

    public List<Assignment> calculatedWeights() {
        return null;
    }
    public void setGradesLost(){

    }

}
