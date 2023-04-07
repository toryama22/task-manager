package com.aidarkstu.service;

import com.aidarkstu.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department update(Long id, Department department);
    void deleteById(Long id);
    Department findById(Long id);
    List<Department> getDepartments();
}
