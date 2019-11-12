package com.java.course.lab03.solution;


import com.java.course.lab03.solution.enums.IssueResolution;
import com.java.course.lab03.solution.enums.WorkAction;
import com.java.course.lab03.solution.exceptions.IssueNotResolvableException;
import com.java.course.lab03.solution.interfaces.Filter;
import com.java.course.lab03.solution.interfaces.Repository;
import com.java.course.lab03.solution.issues.Issue;

public class Jira implements Filter, Repository {

    private Issue[] issues;

    public Jira() {
        issues = new Issue[100];
    }

    public void addActionToIssue(Issue issue, WorkAction action, String actionDescription) {
        if (issue != null) {
            Integer indexOfIssue = getIndexOfIssue(issue.getIssueID());
            issues[indexOfIssue].addAction(action, actionDescription);
        }
    }

    public void resolveIssue(Issue issue, IssueResolution resolution) throws IssueNotResolvableException {
        if (issue != null) {
            Integer indexOfIssue = getIndexOfIssue(issue.getIssueID());
            issues[indexOfIssue].resolve(resolution);
        }
    }

    @Override
    public Issue find(String issueID) {
        Integer indexOfCurrentIssue = getIndexOfIssue(issueID);
        if (indexOfCurrentIssue == null) {
            return null;
        }
        return issues[indexOfCurrentIssue];
    }

    @Override
    public void addIssue(Issue issue) {
        if (issue == null || (issue.getIssueID()) != null) {
            return;
        }
        try {
            issues[getNumberOfIssues()] = issue;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNumberOfIssues() {
        return this.issues.length;
    }

    private Integer getIndexOfIssue(String issueID) {
        for (int i = 0; i < getNumberOfIssues(); i++) {
            if (issues[i].getIssueID().equals(issueID)) {
                return i;
            }
        }
        return null;
    }

}
