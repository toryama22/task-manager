package com.aidarkstu.dto;

import com.aidarkstu.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto extends BaseDto {
    String positionTitle;

    public PositionDto(Position position) {
        super(position);
        this.positionTitle = position.getPositionTitle();
    }
}
