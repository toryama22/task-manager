package com.aidarkstu.dto;

import com.aidarkstu.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto {
    protected Long id;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    protected Date createdDate;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    protected Date modifiedDate;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm:ss")
    protected Date deletedDate;

    protected String modifiedBy;

    public BaseDto(BaseEntity entity) {
        this.id = entity.getId();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.deletedDate = entity.getDeletedDate();
        this.modifiedBy = entity.getModifiedBy();
    }
}