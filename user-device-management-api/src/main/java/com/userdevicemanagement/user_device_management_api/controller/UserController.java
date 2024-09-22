package com.userdevicemanagement.user_device_management_api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdevicemanagement.user_device_management_api.dto.UserDto;
import com.userdevicemanagement.user_device_management_api.model.User;
import com.userdevicemanagement.user_device_management_api.responseDto.UserResponse;
import com.userdevicemanagement.user_device_management_api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/AddUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDto userDto) {
        User user = userService.addUser(userDto);
        return ResponseEntity.ok(new UserResponse(user, "User added successfully"));
    }

    @GetMapping("/GetAllUsers")
    public ResponseEntity<UserResponse> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.ok(new UserResponse(null, "No users found"));
        }
        return ResponseEntity.ok(new UserResponse(users, "Users fetched successfully"));
    }

    @GetMapping("/GetUserById/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(new UserResponse(user, "User found"));
    }

    @PutMapping("/UpdateUser/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(new UserResponse(updatedUser, "User updated successfully"));
    }

    @DeleteMapping("/DeleteUserById/{userId}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok(new UserResponse(null, "User deleted successfully"));
    }
}
