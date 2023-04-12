package com.aidarkstu.repository;

import com.aidarkstu.entity.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType, Long> {
    @Override
    @Modifying
    @Query("UPDATE IssueType it SET it.deletedDate=current_timestamp WHERE it.id=:id")
    void deleteById(Long id);

    IssueType findAllByIdAndDeletedDateIsNull(Long id);
    List<IssueType> findAllByDeletedDateIsNull();
}
