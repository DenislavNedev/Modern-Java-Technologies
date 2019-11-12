package com.java.course.lab03.solution.issues;

import com.java.course.lab03.solution.enums.IssuePriority;
import com.java.course.lab03.solution.enums.IssueResolution;
import com.java.course.lab03.solution.enums.WorkAction;
import com.java.course.lab03.solution.exceptions.IssueNotResolvableException;

public class Feature extends Issue {
    private boolean isThereDesignInLog;
    private boolean isThereImplementationInLog;
    private boolean isThereTestsInLog;

    public Feature(IssuePriority priority, Component component, String description) {
        super(priority, component, description);
        this.isThereDesignInLog = false;
        this.isThereImplementationInLog = false;
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
        return isThereDesignInLog && isThereTestsInLog && isThereImplementationInLog;
    }

    private void checkWorkAction(WorkAction action) {
        if (action == WorkAction.DESIGN) {
            isThereDesignInLog = true;
        }
        if (action == WorkAction.IMPLEMENTATION) {
            isThereImplementationInLog = true;
        }
        if (action == WorkAction.TESTS) {
            isThereTestsInLog = true;
        }
    }
}
