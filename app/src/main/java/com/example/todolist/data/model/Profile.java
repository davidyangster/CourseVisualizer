package com.example.todolist.data.model;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile {
    public String userName;
    public String password;
    public List<Course> courses;

    //there should be one list of profiles declared as static in MAIN

    public Profile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        courses = new ArrayList<>();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

//use name to get course in list of courses
    public Course getCourse(String course) {
        Course tempCourse = null;
        for (Course c : courses) {
            if(c.getCourseName().equals(c)) {
                tempCourse = c;
            }
        }
        return tempCourse;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        } else {
            //throw exceptions
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            //throw exceptions
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(userName, profile.userName) &&
                Objects.equals(password, profile.password);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}