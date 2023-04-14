package com.aidarkstu.service;

import com.aidarkstu.entity.Issue;
import com.aidarkstu.entity.Project;

import java.util.List;

public interface IssueService {
    Issue save(
            Long projectId,
            Long creatorEmployeeId,
            Long assigneeEmployeeId,
            Long issueTypeId,
            Issue issue
    );

    Issue update(
            Long id,
            Long projectId,
            Long creatorEmployeeId,
            Long assigneeEmployeeId,
            Long issueTypeId,
            Issue issue
    );

    void deleteById(Long id);
    Issue findById(Long id);
    List<Issue> getIssues();
}
