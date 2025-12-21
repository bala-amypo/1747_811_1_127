package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintRepository complaintRepository;
    private final ComplaintStatusRepository statusRepository;

    public ComplaintStatusServiceImpl(ComplaintRepository complaintRepository,
                                      ComplaintStatusRepository statusRepository) {
        this.complaintRepository = complaintRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public ComplaintStatus updateStatus(Long complaintId, Complaint.Status status) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(status);
        complaintRepository.save(complaint);

        ComplaintStatus cs = new ComplaintStatus();
        cs.setComplaint(complaint);
        cs.setStatus(status);

        return statusRepository.save(cs);
    }

    @Override
    public List<ComplaintStatus> getStatusHistory(Long complaintId) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        return statusRepository.findByComplaintOrderByUpdatedOnAsc(complaint);
    }
}
