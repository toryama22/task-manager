package com.aidarkstu.entity;

import com.aidarkstu.dto.IssueTypeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueType extends BaseEntity {
    private String typeName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String iconUrl;

    public IssueType(IssueTypeDto dto) {
        super(dto);
        this.typeName = dto.getTypeName();
        this.description = dto.getDescription();
        this.iconUrl = dto.getIconUrl();
    }



}
