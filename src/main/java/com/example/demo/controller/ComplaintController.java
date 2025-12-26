package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/{id}")
    public Optional<Complaint> getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        return complaintService.updateComplaint(id, complaint);
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
