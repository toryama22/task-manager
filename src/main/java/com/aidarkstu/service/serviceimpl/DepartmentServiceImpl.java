package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.Department;
import com.aidarkstu.repository.DepartmentRepository;
import com.aidarkstu.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department save(Department department) {
        department.setCreatedDate(new Date());
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            department.setModifiedDate(new Date());
            return departmentRepository.save(department);
        } else {
            throw new NoSuchElementException("No department found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAllByDeletedDateIsNull();
    }
}
