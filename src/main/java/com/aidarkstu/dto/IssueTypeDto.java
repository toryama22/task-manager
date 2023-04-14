package com.aidarkstu.dto;

import com.aidarkstu.entity.IssueType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTypeDto extends BaseDto {
    private String typeName;
    private String description;
    private String iconUrl;

    public IssueTypeDto(IssueType issueType) {
        super(issueType);
        this.typeName = issueType.getTypeName();
        this.description = issueType.getDescription();
        this.iconUrl = issueType.getIconUrl();
    }
}
