package com.userdevicemanagement.user_device_management_api.service;

import com.userdevicemanagement.user_device_management_api.dto.UserDto;
import com.userdevicemanagement.user_device_management_api.model.User;
import com.userdevicemanagement.user_device_management_api.repository.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDto userDto) {
    	String userId = generateUserId(userDto);
        User user = new User();
        user.setId(ObjectId.get());
        user.setUserId(userId);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User updateUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUpdatedDate(LocalDateTime.now());

        return userRepository.save(user);
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
    
    /*=====UTILITY METHODS=====*/

    private String generateUserId(UserDto userDto) {
        StringBuilder namePartBuilder = new StringBuilder();
        String name = userDto.getName();

        for (char ch : name.toCharArray()) {
            if (ch != ' ' && namePartBuilder.length() < 3) {
                namePartBuilder.append(ch);
            }
        }

        String namePart = namePartBuilder.toString().toUpperCase();
        while (namePart.length() < 3) {
            namePart += 'X'; // or any other padding character
        }

        String phonePart = userDto.getPhoneNumber().substring(userDto.getPhoneNumber().length() - 4);
        
        Random random = new Random();
        
        int randomNumber = 1001 + random.nextInt(9999 - 1001 + 1);

        return "USR-" + namePart + "-" + phonePart + "-" + randomNumber;
    }

}