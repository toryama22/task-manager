package com.aidarkstu.repository;

import com.aidarkstu.entity.Department;
import com.aidarkstu.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    @Modifying
    @Query("UPDATE Project p SET p.deletedDate=current_timestamp WHERE p.id=:id")
    void deleteById(Long id);

    Project findAllByIdAndDeletedDateIsNull(Long id);
    List<Project> findAllByDeletedDateIsNull();
}
