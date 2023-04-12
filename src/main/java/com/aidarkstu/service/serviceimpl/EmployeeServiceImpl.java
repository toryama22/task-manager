package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.Employee;
import com.aidarkstu.repository.EmployeeRepository;
import com.aidarkstu.service.DepartmentService;
import com.aidarkstu.service.EmployeeService;
import com.aidarkstu.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    @Override
    public Employee save(Long positionId, Long departmentId, Long managerId, Employee employee) {
        employee.setCreatedDate(new Date());
        employee.setPosition(positionService.findById(positionId));
        employee.setDepartment(departmentService.findById(departmentId));
        employee.setManager(employeeRepository.findById(managerId).orElseThrow());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            employee.setModifiedDate(new Date());
            return employeeRepository.save(employee);
        }
        throw new NoSuchElementException("No project found with id " + id);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setDeletedDate(new Date());
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAllByDeletedDateIsNull();
    }
}
