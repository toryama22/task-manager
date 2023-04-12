package com.aidarkstu.service;

import com.aidarkstu.entity.IssueType;

import java.util.List;

public interface IssueTypeService {
    IssueType save(IssueType issueType);
    IssueType update(Long id, IssueType issueType);
    void deleteById(Long id);
    IssueType findById(Long id);
    List<IssueType> getIssueTypes();
}
