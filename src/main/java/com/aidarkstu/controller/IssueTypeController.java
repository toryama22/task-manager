package com.aidarkstu.controller;

import com.aidarkstu.dto.IssueTypeDto;
import com.aidarkstu.entity.IssueType;
import com.aidarkstu.service.IssueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/issueType")
@RequiredArgsConstructor
public class IssueTypeController {
    private final IssueTypeService issueTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<IssueTypeDto> getIssueType(@PathVariable("id") Long id) {
        try {
            IssueTypeDto issueTypeDto = new IssueTypeDto(issueTypeService.findById(id));
            return new ResponseEntity<>(issueTypeDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<IssueTypeDto>> getIssueTypes() {
        List<IssueTypeDto> issueTypeDtos = issueTypeService.getIssueTypes().stream()
                .map(IssueTypeDto::new)
                .toList();
        return new ResponseEntity<>(issueTypeDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IssueTypeDto> saveIssueType(@RequestBody IssueTypeDto dto) {
        IssueType savedIssueType = issueTypeService.save(new IssueType(dto));
        return new ResponseEntity<>(new IssueTypeDto(savedIssueType), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueTypeDto> updateIssueType(@PathVariable("id") Long id, @RequestBody IssueTypeDto dto) {
        IssueType updatedIssueType = issueTypeService.update(id, new IssueType(dto));
        dto.setModifiedDate(updatedIssueType.getModifiedDate());
        dto.setId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssueType(@PathVariable("id") Long id) {
        issueTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
