package com.aidarkstu.service;

import com.aidarkstu.entity.Position;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
    Position save(Position position);
    Position update(Long id, Position position);
    void deleteById(Long id);
    Position findById(Long id);
}
