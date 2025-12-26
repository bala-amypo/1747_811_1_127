package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(
            @RequestBody ComplaintRequest request,
            @RequestParam String userEmail) {

        User user = userService.findByEmail(userEmail);
        Complaint complaint = complaintService.submitComplaint(request, user);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Complaint>> getUserComplaints(
            @RequestParam String userEmail) {

        User user = userService.findByEmail(userEmail);
        return ResponseEntity.ok(
                complaintService.getComplaintsForUser(user)
        );
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints()
        );
    }
}
