package com.example.todolist.data.model;

import java.util.Objects;

public class Assignment {
    String assignmentName;
    int assignmentWeight;

    public Assignment(String assignmentName, int assignmentWeight) {
        this.assignmentName = assignmentName;
        this.assignmentWeight = assignmentWeight;

    }


    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getAssignmentWeight() {
        return assignmentWeight;
    }

    public void setAssignmentWeight(int assignmentWeight) {
        this.assignmentWeight = assignmentWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(assignmentName, that.assignmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentName);
    }
}