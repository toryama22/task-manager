package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.Issue;
import com.aidarkstu.repository.IssueRepository;
import com.aidarkstu.service.EmployeeService;
import com.aidarkstu.service.IssueService;
import com.aidarkstu.service.IssueTypeService;
import com.aidarkstu.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ProjectService projectService;
    private final EmployeeService employeeService;
    private final IssueTypeService issueTypeService;

    @Override
    public Issue save(
            Long projectId,
            Long creatorEmployeeId,
            Long assigneeEmployeeId,
            Long issueTypeId,
            Issue issue
    ) {
        issue.setProject(projectService.findById(projectId));
        issue.setCreatorEmployee(employeeService.findById(creatorEmployeeId));
        issue.setAssigneeEmployee(employeeService.findById(assigneeEmployeeId));
        issue.setIssueType(issueTypeService.findById(issueTypeId));
        issue.setCreatedDate(new Date());

        return issueRepository.save(issue);
    }

    @Override
    public Issue update(
            Long id,
            Long projectId,
            Long creatorEmployeeId,
            Long assigneeEmployeeId,
            Long issueTypeId,
            Issue issue
    ) {
        if (issueRepository.existsById(id)) {
            issue.setId(id);
            issue.setProject(projectService.findById(projectId));
            issue.setCreatorEmployee(employeeService.findById(creatorEmployeeId));
            issue.setAssigneeEmployee(employeeService.findById(assigneeEmployeeId));
            issue.setIssueType(issueTypeService.findById(issueTypeId));
            issue.setModifiedDate(new Date());
            return issueRepository.save(issue);
        } else {
            throw new NoSuchElementException("No issue found with id " + id);
        }

    }

    @Override
    public void deleteById(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public Issue findById(Long id) {
        return issueRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<Issue> getIssues() {
        return issueRepository.findAllByDeletedDateIsNull();
    }
}
