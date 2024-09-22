package com.userdevicemanagement.user_device_management_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdevicemanagement.user_device_management_api.dto.UserDeviceLinkDto;
import com.userdevicemanagement.user_device_management_api.model.User;
import com.userdevicemanagement.user_device_management_api.model.UserDeviceLink;
import com.userdevicemanagement.user_device_management_api.repository.UserDeviceLinkRepository;
import com.userdevicemanagement.user_device_management_api.repository.UserRepository;

import java.util.List;

@Service
public class UserDeviceLinkService {

    @Autowired
    private UserDeviceLinkRepository userDeviceLinkRepository;

    @Autowired
    private UserRepository userRepository;

    public UserDeviceLink linkUserToDevice(UserDeviceLinkDto userDeviceLinkDto) {
        User user = userRepository.findById(userDeviceLinkDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        UserDeviceLink userDeviceLink = new UserDeviceLink();
        userDeviceLink.setUser(user);
        userDeviceLink.setDeviceId(userDeviceLinkDto.getDeviceId());

        return userDeviceLinkRepository.save(userDeviceLink);
    }

    public List<UserDeviceLink> getAllUserDeviceLinks() {
        return userDeviceLinkRepository.findAll();
    }
}
