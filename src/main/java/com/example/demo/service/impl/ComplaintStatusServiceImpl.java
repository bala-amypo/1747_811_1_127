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

    private final ComplaintStatusRepository statusRepository;
    private final ComplaintRepository complaintRepository;

    public ComplaintStatusServiceImpl(
            ComplaintStatusRepository statusRepository,
            ComplaintRepository complaintRepository) {
        this.statusRepository = statusRepository;
        this.complaintRepository = complaintRepository;
    }

    @Override
    public ComplaintStatus addStatus(Long complaintId, String status) {
        Complaint complaint = complaintRepository.findById(complaintId).orElseThrow();

        ComplaintStatus cs = new ComplaintStatus();
        cs.setComplaint(complaint);
        cs.setStatus(Complaint.Status.valueOf(status));

        return statusRepository.save(cs);
    }

    @Override
    public List<ComplaintStatus> getStatusHistory(Long complaintId) {
        Complaint complaint = complaintRepository.findById(complaintId).orElseThrow();
        return statusRepository.findByComplaintOrderByUpdatedOnAsc(complaint);
    }
}
