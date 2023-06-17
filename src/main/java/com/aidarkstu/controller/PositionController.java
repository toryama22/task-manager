package com.aidarkstu.controller;

import com.aidarkstu.dto.PositionDto;
import com.aidarkstu.entity.Position;
import com.aidarkstu.service.serviceimpl.PositionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionServiceImpl positionService;

    @GetMapping("/{id}")
    public ResponseEntity<PositionDto> getPosition(@PathVariable("id") Long id) {
        try {
            PositionDto positionDto = new PositionDto(positionService.findById(id));
            return new ResponseEntity<>(positionDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<List<PositionDto>> getPositions() {
        List<PositionDto> positions = positionService.getPositions().stream()
                .map(PositionDto::new)
                .toList();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PositionDto> savePosition(@RequestBody PositionDto dto) {
        Position savedPosition = positionService.save(new Position(dto));
        dto.setId(savedPosition.getId());
        dto.setCreatedDate(savedPosition.getCreatedDate());
        dto.setPositionTitle(savedPosition.getPositionTitle());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDto> updatePosition(@PathVariable("id") Long id, @RequestBody PositionDto dto) {
        Position updatedPosition = positionService.update(id, new Position(dto));
        dto.setModifiedDate(updatedPosition.getModifiedDate());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        positionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
