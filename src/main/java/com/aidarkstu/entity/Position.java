package com.aidarkstu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
public class Position extends BaseEntity {
    @Column(name = "position_title", length = 100)
    String positionTitle;
}
