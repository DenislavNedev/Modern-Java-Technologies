package com.java.course.lab03.solution.issues;


import com.java.course.lab03.solution.enums.IssuePriority;
import com.java.course.lab03.solution.enums.IssueResolution;
import com.java.course.lab03.solution.enums.IssueStatus;
import com.java.course.lab03.solution.enums.WorkAction;
import com.java.course.lab03.solution.exceptions.IssueNotResolvableException;

import java.time.LocalDateTime;

public abstract class Issue {

    private static int idNumber = 0;
    private String issueID;
    private String description;
    private IssuePriority priority;
    private IssueResolution resolution;
    private IssueStatus status;
    private Component component;
    private String[] actionLog;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    public Issue(IssuePriority priority, Component component, String description) {
        this.issueID = createId(component);
        this.priority = priority;
        this.component = component;
        this.description = description;
        this.resolution = IssueResolution.UNRESOLVED;
        this.status = IssueStatus.OPEN;
        this.actionLog = new String[20];
        this.createdOn = LocalDateTime.now();
        this.lastModifiedOn = LocalDateTime.now();
    }

    public String getIssueID() {
        return issueID;
    }

    public String createId(Component component) {
        if (component != null && component.getName() != null && component.getName() != null) {
            return component.getShortName() + "-" + idNumber++;
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public IssueResolution getResolution() {
        return resolution;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public Component getComponent() {
        return component;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String[] getActionLog() {
        return actionLog;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public void addAction(WorkAction action, String description) {
        int currentNumberOfLogs = getActionLogsLength();
        if (currentNumberOfLogs >= 20) {
            throw new ArrayStoreException();
        }
        actionLog[currentNumberOfLogs] = createActionLogElement(action, description);
    }

    public abstract void resolve(IssueResolution resolution) throws IssueNotResolvableException;

    private int getActionLogsLength() {
        return this.actionLog.length;
    }

    /*
    ActionLogElement have this structure <action>: <description>
    Example: "fix: Added 'products.manage' scope check in authorizer"
     */
    private String createActionLogElement(WorkAction action, String description) {
        if (action != null && description != null) {
            return action.toString() + ": " + description;
        }
        return null;
    }

    protected void setIssueResolution(IssueResolution issueResolution) {
        this.resolution = issueResolution;
    }
}
