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

    @PostMapping("/update/{complaintId}")
    public ComplaintStatus updateStatus(
            @PathVariable Long complaintId,
            @RequestParam String status) {
        return complaintStatusService.addStatus(complaintId, status);
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getHistory(@PathVariable Long complaintId) {
        return complaintStatusService.getStatusHistory(complaintId);
    }
}
