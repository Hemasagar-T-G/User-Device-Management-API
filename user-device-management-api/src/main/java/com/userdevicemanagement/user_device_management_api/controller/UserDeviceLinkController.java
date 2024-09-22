package com.userdevicemanagement.user_device_management_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.userdevicemanagement.user_device_management_api.dto.UserDeviceLinkDto;
import com.userdevicemanagement.user_device_management_api.model.UserDeviceLink;
import com.userdevicemanagement.user_device_management_api.responseDto.UserDeviceLinkResponse;
import com.userdevicemanagement.user_device_management_api.service.UserDeviceLinkService;

import java.util.List;

@RestController
@RequestMapping("/api/userDeviceLink")
public class UserDeviceLinkController {

    @Autowired
    private UserDeviceLinkService userDeviceLinkService;

    @PostMapping("/AddUserDeviceLink")
    public ResponseEntity<UserDeviceLinkResponse> linkUserToDevice(@RequestBody UserDeviceLinkDto userDeviceLinkDto) {
        UserDeviceLink linkedDevice = userDeviceLinkService.linkUserToDevice(userDeviceLinkDto);
        return ResponseEntity.ok(new UserDeviceLinkResponse(linkedDevice, "User and device linked successfully"));
    }

    @GetMapping("/GetAllUserDeviceLink")
    public ResponseEntity<UserDeviceLinkResponse> getAllUserDeviceLinks() {
        List<UserDeviceLink> links = userDeviceLinkService.getAllUserDeviceLinks();
        if (links.isEmpty()) {
            return ResponseEntity.ok(new UserDeviceLinkResponse("No user-device links found", null));
        }
        return ResponseEntity.ok(new UserDeviceLinkResponse(links, "User-device links fetched successfully"));
    }
}
