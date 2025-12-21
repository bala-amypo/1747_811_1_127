package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint, Long customerId);

    List<Complaint> getComplaintsForUser(Long customerId);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateStatus(Long complaintId, Complaint.Status status);
}
