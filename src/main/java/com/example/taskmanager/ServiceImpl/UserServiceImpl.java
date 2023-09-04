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

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity RegistrationUser(UserEntity userEntity) {
        String hashedPassword = BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt());
        userEntity.setPassword(hashedPassword);
        return userRepository.save(userEntity);
    }

    @Override
    public boolean emailExistsInDatabase(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return userEntity.isPresent();
    }

    @Override
    public boolean checkUserLogin(String email, String password) {
        Optional<UserEntity> userEntityOpt  = userRepository.findByEmail(email);
        // Kiểm tra xem Optional có chứa giá trị không
        if (userEntityOpt.isPresent()) {
            UserEntity userEntity = userEntityOpt.get();
            return BCrypt.checkpw(password, userEntity.getPassword());
        }
        return false;
    }


}
