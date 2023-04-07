package com.aidarkstu.repository;

import com.aidarkstu.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    @Modifying
    @Query("UPDATE Department d SET d.deletedDate=current_timestamp WHERE d.id=:id")
    void deleteById(Long id);

    List<Department> findAllByDeletedDateIsNull();
}
