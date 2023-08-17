package com.example.taskmanager.ServiceImpl;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUser() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity deleteUser(UserEntity userEntity) {
        return null;
    }
}
