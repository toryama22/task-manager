package com.aidarkstu.entity;

import com.aidarkstu.constant.IssuePriority;
import com.aidarkstu.constant.IssueStatus;
import com.aidarkstu.dto.IssueDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Employee creatorEmployee;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Employee assigneeEmployee;


    @ManyToOne
    @JoinColumn(name = "issue_type_id")
    private IssueType issueType;

    @Enumerated(EnumType.STRING)
    private IssuePriority priority;

    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String summary;
    private String environment;
    private Date dueDate;
    private Date timeOriginalEstimate;
    private Date timeEstimate;
    private Date timeSpent;

    public Issue(IssueDto dto) {
        super(dto);
        this.priority = dto.getPriority();
        this.status = dto.getStatus();
        this.summary = dto.getSummary();
        this.description = dto.getDescription();
        this.environment = dto.getEnvironment();
        this.dueDate = dto.getDueDate();
        this.timeOriginalEstimate = dto.getTimeOriginalEstimate();
        this.timeEstimate = dto.getTimeEstimate();
        this.timeSpent = dto.getTimeSpent();
    }

}
