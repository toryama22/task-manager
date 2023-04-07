package com.aidarkstu.dto;

import com.aidarkstu.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto extends BaseDto {
    String departmentName;
    String description;

    public DepartmentDto(Department department) {
        super(department);
        this.departmentName = department.getDepartmentName();
        this.description = department.getDescription();
    }
}
