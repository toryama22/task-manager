package com.aidarkstu.service;

import com.aidarkstu.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Long positionId, Long departmentId, Long managerId, Employee employee);
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
    Employee findById(Long id);
    List<Employee> getEmployees();
}
