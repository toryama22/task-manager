package com.aidarkstu.entity;

import com.aidarkstu.dto.BaseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(name = "created_date")
    protected Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    protected Date modifiedDate;

    @Column(name = "deleted_date")
    protected Date deletedDate;

    @Column(name = "modified_by")
    protected String modifiedBy;

    public BaseEntity(BaseDto dto) {
        this.id = dto.getId();
        this.createdDate = dto.getCreatedDate();
        this.modifiedDate = dto.getModifiedDate();
        this.deletedDate = dto.getDeletedDate();
        this.modifiedBy = dto.getModifiedBy();
    }
}
