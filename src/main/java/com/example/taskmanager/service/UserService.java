package com.example.taskmanager.service;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    UserEntity registerUser(RegistrationRequest request);
    Optional<UserEntity> findByEmail(String email);
    UserEntity deleteUser(UserEntity userEntity);

    void saveUserVerificationToken(UserEntity theUser, String verificationToken);
}
