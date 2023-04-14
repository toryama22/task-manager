package com.aidarkstu.dto;

import com.aidarkstu.constant.IssuePriority;
import com.aidarkstu.constant.IssueStatus;
import com.aidarkstu.entity.Issue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto extends BaseDto {
    private Long projectId;
    private Long creatorEmployeeId;
    private Long assigneeEmployeeId;
    private Long issueTypeId;
    private IssuePriority priority;
    private IssueStatus status;
    private String summary;
    private String description;
    private String environment;
    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    private Date dueDate;
    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    private Date timeOriginalEstimate;
    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    private Date timeEstimate;
    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    private Date timeSpent;

    public IssueDto(Issue issue) {
        super(issue);

        if (issue.getProject() != null) {
            this.projectId = issue.getProject().getId();
        }

        if (issue.getCreatorEmployee() != null) {
            this.creatorEmployeeId = issue.getCreatorEmployee().getId();
        }

        if (issue.getAssigneeEmployee() != null) {
            this.assigneeEmployeeId = issue.getAssigneeEmployee().getId();
        }

        if (issue.getIssueType() != null) {
            this.issueTypeId = issue.getIssueType().getId();
        }

        this.priority = issue.getPriority();
        this.status = issue.getStatus();
        this.summary = issue.getSummary();
        this.description = issue.getDescription();
        this.environment = issue.getEnvironment();
        this.dueDate = issue.getDueDate();
        this.timeOriginalEstimate = issue.getTimeOriginalEstimate();
        this.timeEstimate = issue.getTimeEstimate();
        this.timeSpent = issue.getTimeSpent();
    }
}
