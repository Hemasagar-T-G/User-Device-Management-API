package com.userdevicemanagement.user_device_management_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDeviceLinks")
public class UserDeviceLink {
    @Id
    private String id;         // Unique identifier for the link
    private User user;        // Full User object
    private String deviceId;   // Device ID (as a string)

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}