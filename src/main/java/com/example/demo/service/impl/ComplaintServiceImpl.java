package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;
    private final UserRepository userRepository;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService,
            UserRepository userRepository) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
        this.userRepository = userRepository;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint, Long customerId) {
        User customer = userRepository.findById(customerId).orElseThrow();

        complaint.setCustomer(customer);
        complaint.setPriorityScore(priorityRuleService.computePriorityScore(complaint));

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(Long customerId) {
        User user = userRepository.findById(customerId).orElseThrow();
        return complaintRepository.findByCustomer(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public Complaint updateStatus(Long complaintId, Complaint.Status status) {
        Complaint complaint = complaintRepository.findById(complaintId).orElseThrow();
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}
