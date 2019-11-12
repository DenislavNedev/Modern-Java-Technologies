package com.java.course.lab03.solution.issues;


import com.java.course.lab03.solution.enums.IssuePriority;
import com.java.course.lab03.solution.enums.IssueResolution;
import com.java.course.lab03.solution.enums.WorkAction;

import java.security.InvalidParameterException;

public class Task extends Issue {

    public Task(IssuePriority priority, Component component, String description) {
        super(priority, component, description);
    }

    @Override
    public void addAction(WorkAction action, String description) {
        if (isActionValid(action)) {
            super.addAction(action, description);
        } else {
            throw new InvalidParameterException();
        }
    }

    private boolean isActionValid(WorkAction workAction) {
        return workAction != WorkAction.FIX && workAction != WorkAction.IMPLEMENTATION && workAction != WorkAction.TESTS;
    }

    @Override
    public void resolve(IssueResolution resolution) {
        super.setIssueResolution(resolution);
    }
}
