package com.aidarkstu.service;

import com.aidarkstu.entity.Position;
import com.aidarkstu.entity.Project;

import java.util.List;

public interface ProjectService {
    Project save(Long projectLeadId, Project project);
    Project update(Long id, Long projectLeadId, Project project);
    void deleteById(Long id);
    Project findById(Long id);
    List<Project> getProjects();
}
