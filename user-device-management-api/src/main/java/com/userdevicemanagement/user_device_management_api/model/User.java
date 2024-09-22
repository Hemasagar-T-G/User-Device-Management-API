package com.userdevicemanagement.user_device_management_api.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

@Document(collection = "Users") // Specify the collection name
public class User {

    @Id
    private ObjectId id; // MongoDB ObjectId
    private String userId; // Custom user ID
    private String name;
    private String email;
    private String phoneNumber;
    @CreatedDate
    private LocalDateTime createdDate; // Automatically populated on creation

    @LastModifiedDate
    private LocalDateTime updatedDate; // Automatically populated on update

 // No-argument constructor (required)
    public User() {
    }

    // All-argument constructor (optional)
    public User(ObjectId id, String userId, String name, String email, String phoneNumber, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

	// Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    
    // Manual methods to set dates if required
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
