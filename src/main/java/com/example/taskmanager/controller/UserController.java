package com.example.taskmanager.controller;

import com.example.taskmanager.ServiceImpl.UserServiceImpl;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller("/users")
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/findAllUser")
    public List<UserEntity> findAllUser(){
        return userService.findAllUser();
    }
}
