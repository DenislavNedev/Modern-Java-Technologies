package com.java.course.lab03.solution.issues;


import com.java.course.lab03.solution.enums.IssuePriority;
import com.java.course.lab03.solution.enums.IssueResolution;
import com.java.course.lab03.solution.enums.WorkAction;
import com.java.course.lab03.solution.exceptions.IssueNotResolvableException;

public class Bug extends Issue {
    private boolean isThereFixInLog;
    private boolean isThereTestsInLog;

    public Bug(IssuePriority priority, Component component, String description) {
        super(priority, component, description);
        this.isThereFixInLog = false;
        this.isThereTestsInLog = false;
    }

    @Override
    public void resolve(IssueResolution resolution) throws IssueNotResolvableException {
        if (isIssueResolvable()) {
            super.setIssueResolution(resolution);
        } else {
            throw new IssueNotResolvableException();
        }
    }

    @Override
    public void addAction(WorkAction action, String description) {
        checkWorkAction(action);
        super.addAction(action, description);
    }

    private boolean isIssueResolvable() {
        return isThereFixInLog && isThereTestsInLog;
    }

    private void checkWorkAction(WorkAction action) {
        if (action == WorkAction.DESIGN) {
            isThereFixInLog = true;
        }
        if (action == WorkAction.TESTS) {
            isThereTestsInLog = true;
        }
    }

}
