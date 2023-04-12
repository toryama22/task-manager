package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.Project;
import com.aidarkstu.repository.ProjectRepository;
import com.aidarkstu.service.EmployeeService;
import com.aidarkstu.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;

    @Override
    public Project save(Long projectLeadId, Project project) {
        project.setCreatedDate(new Date());
        project.setProjectLead(employeeService.findById(projectLeadId));
        return projectRepository.save(project);
    }

    @Override
    public Project update(Long id, Long projectLeadId, Project project) {
        if (projectRepository.existsById(id)) {
            project.setId(id);
            project.setModifiedDate(new Date());
            project.setProjectLead(employeeService.findById(projectLeadId));
            return projectRepository.save(project);
        } else {
            throw new NoSuchElementException("No project found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.setDeletedDate(new Date());
        projectRepository.deleteById(id);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAllByDeletedDateIsNull();
    }
}
