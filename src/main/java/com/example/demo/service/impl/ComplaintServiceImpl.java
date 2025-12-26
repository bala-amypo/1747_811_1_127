package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleRepository priorityRuleRepository;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleRepository priorityRuleRepository) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    @Override
    public Complaint updateComplaint(Long id, Complaint complaint) {
        Optional<Complaint> existing = complaintRepository.findById(id);
        if (existing.isPresent()) {
            Complaint c = existing.get();
            c.setTitle(complaint.getTitle());
            c.setDescription(complaint.getDescription());
            c.setSeverity(complaint.getSeverity());
            c.setStatus(complaint.getStatus());
            return complaintRepository.save(c);
        }
        return null;
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
