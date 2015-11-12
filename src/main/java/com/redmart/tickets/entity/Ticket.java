package com.redmart.tickets.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String customerInfo;
    private String createdBy;
    private String assignedTo;
    private String status;
    private String comments;

    public Ticket() {
    }

    public Ticket(String name, String customerInfo, String createdBy, String assignedTo, String status, String comments) {
        this.name = name;
        this.customerInfo = customerInfo;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.status = status;
        this.comments = comments;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerInfo='" + customerInfo + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
