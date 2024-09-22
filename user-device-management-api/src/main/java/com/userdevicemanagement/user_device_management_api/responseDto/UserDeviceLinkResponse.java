package com.userdevicemanagement.user_device_management_api.responseDto;

public class UserDeviceLinkResponse {
    private Object data;
    private String message;

    public UserDeviceLinkResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }

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
