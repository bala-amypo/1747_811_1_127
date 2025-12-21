package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    Complaint getComplaintById(Long id);

    List<Complaint> getAllComplaints();

    Complaint updateComplaint(Long id, Complaint complaint);

    void deleteComplaint(Long id);
}
