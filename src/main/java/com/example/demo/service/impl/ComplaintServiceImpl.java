package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint updateComplaint(Long id, Complaint complaint) {
        Complaint existing = complaintRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(complaint.getTitle());
            existing.setDescription(complaint.getDescription());
            existing.setCategory(complaint.getCategory());
            existing.setChannel(complaint.getChannel());
            existing.setSeverity(complaint.getSeverity());
            existing.setUrgency(complaint.getUrgency());
            existing.setStatus(complaint.getStatus());
            return complaintRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
