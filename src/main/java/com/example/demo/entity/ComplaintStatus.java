package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint_status")
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;   // NEW, OPEN, IN_PROGRESS, RESOLVED

    private String description;

    public ComplaintStatus() {
    }

    public ComplaintStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    // getters and setters

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
}
