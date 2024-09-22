package com.userdevicemanagement.user_device_management_api.responseDto;

public class UserResponse {
    private Object data;
    private String message;

    // Constructors
    public UserResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    // Getters and Setters
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
