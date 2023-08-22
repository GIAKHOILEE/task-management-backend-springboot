package com.example.taskmanager.service;

import com.example.taskmanager.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity deleteUser(UserEntity userEntity);
}
