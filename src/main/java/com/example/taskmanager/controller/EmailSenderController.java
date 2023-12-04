package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.authRequestDTO.EmailRequestDTO;
import com.example.taskmanager.ServiceImpl.EmailSenderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
@RequestMapping("/sendmail")
@RequiredArgsConstructor
public class EmailSenderController {
    private final EmailSenderService senderService;
    private final ConcurrentHashMap<String, Integer> verificationCodes = new ConcurrentHashMap<>();

    @PostMapping("send")
    public ResponseEntity<String> triggerMail(@RequestBody EmailRequestDTO emailRequestDTO) throws MessagingException {
        int verificationCode = generateRandomSixDigitCode();
        //Lưu mã xác minh vào map
        verificationCodes.put(emailRequestDTO.getEmail(), verificationCode);

        senderService.sendSimpleEmail(emailRequestDTO.getEmail(),
                "Mã xác nhận email của bạn là: " + verificationCode,
                "Mã xác nhận email của bạn là "+ verificationCode +" vui lòng không chia sẻ cho bất kì ai");

        return ResponseEntity.ok("Email with verification code sent successfully! "+ verificationCode);
    }

    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestBody EmailRequestDTO emailRequestDTO) {
        int actualCode = verificationCodes.getOrDefault(emailRequestDTO.getEmail(), -1);

        if (actualCode == emailRequestDTO.getVerificationCode()) {
            return ResponseEntity.ok("Verification successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect verification code.");
        }
    }

    public int generateRandomSixDigitCode() {
        return (int) ((Math.random() * (999999 - 100000)) + 100000);
    }
}
