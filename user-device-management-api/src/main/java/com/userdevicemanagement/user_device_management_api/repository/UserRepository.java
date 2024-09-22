package com.userdevicemanagement.user_device_management_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.userdevicemanagement.user_device_management_api.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
