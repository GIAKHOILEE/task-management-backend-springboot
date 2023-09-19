package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.requestDTO.EmailRequestDTO;
import com.example.taskmanager.DTO.requestDTO.UserUpdateRequestDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskmanager.token.decodeToken;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/findAllUser")
    public List<UserEntity> findAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        String email = decodeToken.decodeTokenAndGetEmail(token);

        Optional<UserEntity> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping("/avatar")
    public ResponseEntity<?> getAvatarByEmail(@RequestBody EmailRequestDTO emailRequest) {
        Optional<UserEntity> userEntityOptional = userService.findByEmail(emailRequest.getEmail());

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            return ResponseEntity.ok(Collections.singletonMap("avatar", user.getAvatar()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateUserByEmail(@RequestHeader String email, @RequestBody UserUpdateRequestDTO updateRequest) {
        Optional<UserEntity> existingUser = userService.findByEmail(email);

        if (!existingUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
//        String hashedPassword = BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt());
//        userEntity.setPassword(hashedPassword);
        UserEntity userToUpdate = existingUser.get();
        userToUpdate.setFirstname(updateRequest.getFirstname());
        userToUpdate.setLastname(updateRequest.getLastname());
        userToUpdate.setPassword(updateRequest.getPassword());
        userToUpdate.setPhone(updateRequest.getPhone());
        userToUpdate.setAvatar(updateRequest.getAvatar());

        userService.saveOrUpdate(userToUpdate);

        return ResponseEntity.ok(userToUpdate);
    }

}
