package com.aidarkstu.repository;

import com.aidarkstu.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    @Override
    @Modifying
    @Query("UPDATE Issue i SET i.deletedDate=current_timestamp WHERE i.id=:id")
    void deleteById(Long id);
    Issue findAllByIdAndDeletedDateIsNull(Long id);
    List<Issue> findAllByDeletedDateIsNull();
}
