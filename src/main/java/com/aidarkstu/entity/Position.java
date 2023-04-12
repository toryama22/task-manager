package com.aidarkstu.entity;

import com.aidarkstu.dto.PositionDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Position extends BaseEntity {
    @Column(name = "position_title", length = 100)
    String positionTitle;

    public Position(PositionDto dto) {
        super(dto);
        this.positionTitle = dto.getPositionTitle();
    }

}
