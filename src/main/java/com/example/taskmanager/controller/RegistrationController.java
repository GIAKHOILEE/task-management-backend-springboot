package com.example.taskmanager.controller;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.event.RegistrationCompleteEvent;
import com.example.taskmanager.registration.RegistrationRequest;
import com.example.taskmanager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
        UserEntity user = userService.registerUser(registrationRequest);
        //public registration event
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Success ! check your Email";
    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getServletPath();
    }
}
