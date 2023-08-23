package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.EmailRequestDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;

    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmailExists(@RequestBody EmailRequestDTO emailRequest) {
        boolean exists = userService.emailExistsInDatabase(emailRequest.getEmail());

        if (exists) {
            return ResponseEntity.ok("Email already exists in the database.");
        } else {
            return ResponseEntity.ok("Email does not exist in the database.");
        }
    }

    @PostMapping("/done")
    public UserEntity RegistrationUser(@RequestBody UserEntity userEntity) {
        return userService.RegistrationUser(userEntity);
    }
}