package com.example.taskmanager.controller;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAllUser")
    public List<UserEntity> findAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping("/register")
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

}
