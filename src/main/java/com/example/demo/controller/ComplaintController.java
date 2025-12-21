package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService cs, UserService us) {
        this.complaintService = cs;
        this.userService = us;
    }

    @PostMapping("/submit")
    public Complaint submit(@RequestBody ComplaintRequest request,
                            @RequestParam String email) {
        User user = userService.findByEmail(email);
        return complaintService.submitComplaint(request, user);
    }

    @GetMapping("/user/{email}")
    public List<Complaint> getUserComplaints(@PathVariable String email) {
        return complaintService.getComplaintsForUser(userService.findByEmail(email));
    }

    @GetMapping("/prioritized")
    public List<Complaint> prioritized() {
        return complaintService.getPrioritizedComplaints();
    }
}
