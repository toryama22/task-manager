package com.aidarkstu.controller;

import com.aidarkstu.dto.ProjectDto;
import com.aidarkstu.entity.Project;
import com.aidarkstu.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/project")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") Long id) {
        try {
            ProjectDto projectDto = new ProjectDto(projectService.findById(id));
            return new ResponseEntity<>(projectDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getProjects() {
        List<ProjectDto> projects = projectService.getProjects().stream()
                .map(ProjectDto::new)
                .toList();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto dto) {
        Project savedProject = projectService.save(dto.getProjectLeadId(), new Project(dto));
        ProjectDto responseDto = new ProjectDto(savedProject);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto dto) {
        Project updatedProject = projectService.update(id, dto.getProjectLeadId(), new Project(dto));
        dto.setModifiedDate(updatedProject.getModifiedDate());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
