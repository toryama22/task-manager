package com.aidarkstu.controller;

import com.aidarkstu.dto.IssueDto;
import com.aidarkstu.entity.Issue;
import com.aidarkstu.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/issue")
public class IssueController {
    private final IssueService issueService;

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getIssue(@PathVariable("id") Long id) {
        try {
            IssueDto issueDto = new IssueDto(issueService.findById(id));
            return new ResponseEntity<>(issueDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<IssueDto>> getIssues() {
        List<IssueDto> issues = issueService.getIssues().stream()
                .map(IssueDto::new)
                .toList();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IssueDto> saveIssue(@RequestBody IssueDto dto) {
        Issue savedIssue = issueService.save(
                dto.getProjectId(),
                dto.getCreatorEmployeeId(),
                dto.getAssigneeEmployeeId(),
                dto.getIssueTypeId(),
                new Issue(dto)
        );

        IssueDto responseDto = new IssueDto(savedIssue);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable("id") Long id, @RequestBody IssueDto dto) {
        Issue updatedIssue = issueService.update(
                id,
                dto.getProjectId(),
                dto.getCreatorEmployeeId(),
                dto.getAssigneeEmployeeId(),
                dto.getIssueTypeId(),
                new Issue(dto)
        );
        dto.setId(id);
        dto.setModifiedDate(updatedIssue.getModifiedDate());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable("id") Long id) {
        issueService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
