package com.userdevicemanagement.user_device_management_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.userdevicemanagement.user_device_management_api.model.UserDeviceLink;

@Repository
public interface UserDeviceLinkRepository extends MongoRepository<UserDeviceLink, String> {
    // Custom query methods can be added here if needed
}