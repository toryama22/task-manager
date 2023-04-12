package com.aidarkstu.entity;

import com.aidarkstu.dto.ProjectDto;
import com.aidarkstu.service.EmployeeService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Data
@RequiredArgsConstructor
public class Project extends BaseEntity {
    @Column(name = "project_name", length = 50)
    String projectName;

    @ManyToOne
    @JoinColumn(name = "project_lead_id")
    Employee projectLead;

    @Column(name = "project_description")
    String description;

    public Project(ProjectDto dto) {
        super(dto);
        this.projectName = dto.getProjectName();
        this.description = dto.getDescription();
    }

}
