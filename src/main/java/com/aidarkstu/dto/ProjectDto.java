package com.aidarkstu.dto;

import com.aidarkstu.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto extends BaseDto {
    String projectName;
    Long projectLeadId;
    String description;

    public ProjectDto(Project project) {
        super(project);
        this.projectName = project.getProjectName();
        if (project.getProjectLead() != null)
            this.projectLeadId = project.getProjectLead().getId();
        this.description = project.getDescription();
    }
}
