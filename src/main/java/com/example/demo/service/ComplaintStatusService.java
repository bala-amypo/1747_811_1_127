package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;

import java.util.List;

public interface ComplaintStatusService {

    ComplaintStatus updateStatus(Long complaintId, Complaint.Status status);

    List<ComplaintStatus> getStatusHistory(Long complaintId);
}
