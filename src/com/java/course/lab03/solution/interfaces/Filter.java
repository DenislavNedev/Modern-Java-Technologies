package com.java.course.lab03.solution.interfaces;


import com.java.course.lab03.solution.issues.Issue;

public interface Filter {
    // If there is no such Issue the method should return null
    public Issue find(String issueID);
}
