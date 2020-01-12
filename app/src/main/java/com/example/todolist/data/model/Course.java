package com.example.todolist.data.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    String courseName;
    List<Assignment> courseAssignments;

    public Course(String courseName) {

        this.courseName = courseName;
        this.courseAssignments = new ArrayList<Assignment>();
    }

    public void setCourseAssignments(List<Assignment> courseAssignments) {
        this.courseAssignments = courseAssignments;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public List<Assignment> getCourseAssignments() {
        return courseAssignments;
    }

    public void addCourseAssignment(Assignment assignment) {
        if (!courseAssignments.contains(assignment)) {
            courseAssignments.add(assignment);
        } else {
            //throw exceptions
        }
    }


    public boolean containsAssignment(Assignment assignment) {
        return courseAssignments.contains(assignment);
    }

    public void removeCourseAssignment(Assignment assignment) {
        if (courseAssignments.contains(assignment)) {
            courseAssignments.remove(assignment);
        }
    }

    //access individual assignment using name
    public Assignment getAssignment(String assignmentName) {
        Assignment a = null;
        for (Assignment assignment : courseAssignments) {

            if (assignment.getAssignmentName().equals(assignmentName)) {
                a = assignment;
            }
        }
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }


}