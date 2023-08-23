package com.example.taskmanager.service;

import com.example.taskmanager.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    Optional<UserEntity> findById(Long id);
    UserEntity RegistrationUser(UserEntity userEntity);
    boolean emailExistsInDatabase(String email);
}
