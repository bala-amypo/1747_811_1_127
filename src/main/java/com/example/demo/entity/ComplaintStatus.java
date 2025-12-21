package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Complaint complaint;

    @Enumerated(EnumType.STRING)
    private Complaint.Status status;

    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreate() {
        this.updatedOn = LocalDateTime.now();
    }

    
    public Long getId() {
        return id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Complaint.Status getStatus() {
        return status;
    }

    public void setStatus(Complaint.Status status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
