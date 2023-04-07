package com.aidarkstu.controller;

import com.aidarkstu.dto.DepartmentDto;
import com.aidarkstu.entity.Department;
import com.aidarkstu.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long id) {
        try {
            DepartmentDto departmentDto = new DepartmentDto(departmentService.findById(id));
            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        List<DepartmentDto> departments = departmentService.getDepartments().stream()
                .map(DepartmentDto::new)
                .toList();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto dto) {
        Department savedDepartment = departmentService.save(new Department(dto));
        dto.setId(savedDepartment.getId());
        dto.setCreatedDate(savedDepartment.getCreatedDate());
        dto.setDepartmentName(savedDepartment.getDepartmentName());
        dto.setDescription(savedDepartment.getDescription());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDto dto) {
        Department updatedDepartment = departmentService.update(id, new Department(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
