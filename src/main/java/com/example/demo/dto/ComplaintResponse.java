package com.example.demo.dto;

import com.example.demo.entity.Complaint;

import java.time.LocalDateTime;

public class ComplaintResponse {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String channel;

    private Integer priorityScore;
    private Complaint.Status status;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;

    private LocalDateTime createdAt;

    private Long customerId;
    private Long assignedAgentId;

    /* ---------- Constructors ---------- */

    public ComplaintResponse() {
    }

    public ComplaintResponse(Complaint complaint) {
        this.id = complaint.getId();
        this.title = complaint.getTitle();
        this.description = complaint.getDescription();
        this.category = complaint.getCategory();
        this.channel = complaint.getChannel();
        this.priorityScore = complaint.getPriorityScore();
        this.status = complaint.getStatus();
        this.severity = complaint.getSeverity();
        this.urgency = complaint.getUrgency();
        this.createdAt = complaint.getCreatedAt();

        if (complaint.getCustomer() != null) {
            this.customerId = complaint.getCustomer().getId();
        }
        if (complaint.getAssignedAgent() != null) {
            this.assignedAgentId = complaint.getAssignedAgent().getId();
        }
    }

    /* ---------- Getters & Setters ---------- */

    public Long getId() {
        return id;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public Complaint.Status getStatus() {
        return status;
    }

    public Complaint.Severity getSeverity() {
        return severity;
    }

    public Complaint.Urgency getUrgency() {
        return urgency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getAssignedAgentId() {
        return assignedAgentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getChannel() {
        return channel;
    }
}
