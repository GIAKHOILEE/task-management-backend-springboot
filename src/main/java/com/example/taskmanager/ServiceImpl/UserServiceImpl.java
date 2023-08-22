package com.example.taskmanager.ServiceImpl;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
//        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
//        userEntity.setPassword(encodedPassword);
        String hashedPassword = BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt());
        userEntity.setPassword(hashedPassword);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity deleteUser(UserEntity userEntity) {
        return null;
    }
}
