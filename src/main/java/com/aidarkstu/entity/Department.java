package com.aidarkstu.entity;

import com.aidarkstu.dto.DepartmentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Department extends BaseEntity {
    @Column(name = "department_name", length = 100)
    private String departmentName;
    private String description;

    public Department (DepartmentDto dto) {
        super(dto);
        this.departmentName = dto.getDepartmentName();
        this.description = dto.getDescription();
    }

}
