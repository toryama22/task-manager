package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.Position;
import com.aidarkstu.repository.PositionRepository;
import com.aidarkstu.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public Position save(Position position) {
        position.setCreatedDate(new Date());
        return positionRepository.save(position);
    }

    @Override
    public Position update(Long id, Position position) {
        if (positionRepository.existsById(id)) {
            position.setId(id);
            position.setModifiedDate(new Date());
            return positionRepository.save(position);
        } else {
            throw new NoSuchElementException("No position found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<Position> getPositions() {
        return positionRepository.findAllByDeletedDateIsNull();
    }
}
