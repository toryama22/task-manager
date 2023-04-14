package com.aidarkstu.controller;

import com.aidarkstu.dto.EmployeeDto;
import com.aidarkstu.entity.Employee;
import com.aidarkstu.service.DepartmentService;
import com.aidarkstu.service.EmployeeService;
import com.aidarkstu.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        try {
            EmployeeDto employeeDto = new EmployeeDto(employeeService.findById(id));
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employees = employeeService.getEmployees().stream()
                .map(EmployeeDto::new)
                .toList();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
        Employee savedEmployee = employeeService.save(
                dto.getPositionId(),
                dto.getDepartmentId(),
                dto.getManagerId(),
                new Employee(dto));
        EmployeeDto responseDto = new EmployeeDto(savedEmployee);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto dto) {
        Employee updatedEmployee = employeeService.update(id, new Employee(dto));
        dto.setModifiedDate(updatedEmployee.getModifiedDate());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
