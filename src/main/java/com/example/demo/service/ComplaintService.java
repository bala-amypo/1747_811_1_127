package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;
import java.util.Optional;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();

    Optional<Complaint> getComplaintById(Long id);

    Complaint updateComplaint(Long id, Complaint complaint);

    void deleteComplaint(Long id);  // make sure signature matches
}
