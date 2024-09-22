package com.userdevicemanagement.user_device_management_api.dto;

public class UserDeviceLinkDto {
    private String userId;  // User ID

    private String deviceId; // Device ID

    // Constructors
    public UserDeviceLinkDto() {
    }

    public UserDeviceLinkDto(String userId, String deviceId) {
        this.userId = userId;
        this.deviceId = deviceId;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}