package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService complaintStatusService;

    public StatusController(ComplaintStatusService complaintStatusService) {
        this.complaintStatusService = complaintStatusService;
    }

    @PostMapping
    public ComplaintStatus create(@RequestBody ComplaintStatus status) {
        return complaintStatusService.createStatus(status);
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getHistory(@PathVariable Long complaintId) {
        return complaintStatusService.getStatusByComplaintId(complaintId);
    }
}
