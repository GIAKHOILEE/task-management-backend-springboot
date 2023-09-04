package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.requestDTO.LoginRequestDTO;
import com.example.taskmanager.DTO.responseDTO.TokenResponseDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.service.JwtTokenService;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
        Optional<UserEntity> user = userService.findByEmail(loginRequest.getEmail());

        if (user.isPresent()) {
            UserEntity userEntity = user.get();

            if (BCrypt.checkpw(loginRequest.getPassword(), userEntity.getPassword())) {
                // Nếu password hợp lệ
                String token = jwtTokenService.generateToken(loginRequest.getEmail());
                return ResponseEntity.ok(new TokenResponseDTO(token));
            }
        }
        // Nếu email hoặc password không hợp lệ
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
}
