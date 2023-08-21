package com.example.taskmanager.ServiceImpl;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.exception.UserAlreadyExitsException;
import com.example.taskmanager.registration.RegistrationRequest;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity registerUser(RegistrationRequest request) {
        Optional<UserEntity> user = this.findByEmail(request.email());
        if(user.isPresent()){
            throw new UserAlreadyExitsException("User with email "+ request.email()+ " already exits");
        }
        var newUser = new UserEntity();
        newUser.setFirstname(request.firstname());
        newUser.setLastname(request.lastname());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setPhonenumber(request.phonenumber());
        return userRepository.save(newUser);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity deleteUser(UserEntity userEntity) {
        return null;
    }
}
