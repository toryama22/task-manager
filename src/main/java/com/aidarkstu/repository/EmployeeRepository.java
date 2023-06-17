package com.aidarkstu.repository;

import com.aidarkstu.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    @Modifying
    @Query("UPDATE Employee e SET e.deletedDate=current_timestamp WHERE e.id=:id")
    void deleteById(Long id);
    Employee findAllByIdAndDeletedDateIsNull(Long id);
    List<Employee> findAllByDeletedDateIsNull();

    Optional<Employee> findByEmail(String email);
}
