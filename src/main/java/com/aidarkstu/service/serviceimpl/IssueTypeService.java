package com.aidarkstu.service.serviceimpl;

import com.aidarkstu.entity.IssueType;
import com.aidarkstu.repository.IssueTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueTypeService implements com.aidarkstu.service.IssueTypeService {
    private final IssueTypeRepository issueTypeRepository;

    @Override
    public IssueType save(IssueType issueType) {
        issueType.setCreatedDate(new Date());
        return issueTypeRepository.save(issueType);
    }

    @Override
    public IssueType update(Long id, IssueType issueType) {
        if (issueTypeRepository.existsById(id)) {
            issueType.setId(id);
            issueType.setModifiedDate(new Date());
            return issueTypeRepository.save(issueType);
        }
        throw new NoSuchElementException("No issue type found with id " + id);
    }

    @Override
    public void deleteById(Long id) {
        issueTypeRepository.deleteById(id);
    }

    @Override
    public IssueType findById(Long id) {
        return issueTypeRepository.findAllByIdAndDeletedDateIsNull(id);
    }

    @Override
    public List<IssueType> getIssueTypes() {
        return issueTypeRepository.findAllByDeletedDateIsNull();
    }
}
