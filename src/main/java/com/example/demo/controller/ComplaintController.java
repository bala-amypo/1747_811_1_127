package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    @GetMapping("/{id}")
    public Complaint getById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @GetMapping
    public List<Complaint> getAll() {
        return complaintService.getAllComplaints();
    }

    @PutMapping("/{id}")
    public Complaint update(@PathVariable Long id, @RequestBody Complaint complaint) {
        return complaintService.updateComplaint(id, complaint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
