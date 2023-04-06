package com.aidarkstu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project extends BaseEntity {
    @Column(name = "project_title", length = 50)
    String projectName;

    @Column(name = "manager", length = 50)
    String teamLead;

    @Column(name = "project_description")
    String description;

}
