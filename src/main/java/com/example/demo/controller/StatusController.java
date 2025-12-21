package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService statusService;

    public StatusController(ComplaintStatusService statusService) {
        this.statusService = statusService;
    }

    @PutMapping("/update/{complaintId}")
    public ComplaintStatus updateStatus(@PathVariable Long complaintId,
                                        @RequestParam Complaint.Status status) {
        return statusService.updateStatus(complaintId, status);
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getStatusHistory(@PathVariable Long complaintId) {
        return statusService.getStatusHistory(complaintId);
    }
}
