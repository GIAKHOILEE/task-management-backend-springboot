package com.example.taskmanager.service;

import com.example.taskmanager.DTO.UserUpdateRequestDTO;
import com.example.taskmanager.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByEmail(String email);
    UserEntity RegistrationUser(UserEntity userEntity);
    boolean emailExistsInDatabase(String email);
    boolean checkUserLogin(String email, String password);
    UserEntity saveOrUpdate(UserEntity user, UserUpdateRequestDTO updateRequestDTO);
}
