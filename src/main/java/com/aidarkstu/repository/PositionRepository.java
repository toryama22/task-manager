package com.aidarkstu.repository;

import com.aidarkstu.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    @Override
    @Modifying
    @Query("UPDATE Position p SET p.deletedDate=current_timestamp WHERE p.id=:id")
    void deleteById(Long id);


    List<Position> findAllByDeletedDateIsNull();
}
