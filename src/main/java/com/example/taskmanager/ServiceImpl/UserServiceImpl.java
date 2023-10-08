package com.example.taskmanager.ServiceImpl;

import com.example.taskmanager.DTO.UserUpdateRequestDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.repository.projectRepository.UserProjectRepository;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserProjectRepository userProjectRepository;
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
        if (userEntityOpt.isPresent()) {
            UserEntity userEntity = userEntityOpt.get();
            return BCrypt.checkpw(password, userEntity.getPassword());
        }
        return false;
    }

    @Override
    public UserEntity saveOrUpdate(UserEntity user, UserUpdateRequestDTO updateRequestDTO) {

        if (updateRequestDTO.getFirstname() != null) {
            user.setFirstname(updateRequestDTO.getFirstname());
        }
        if (updateRequestDTO.getLastname() != null) {
            user.setLastname(updateRequestDTO.getLastname());
        }
        if (updateRequestDTO.getPassword() != null) {
            String hashedPassword = BCrypt.hashpw(updateRequestDTO.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
        }
        if (updateRequestDTO.getPhone() != null) {
            user.setPhone(updateRequestDTO.getPhone());
        }
        if (updateRequestDTO.getAvatar() != null) {
            user.setAvatar(updateRequestDTO.getAvatar());
        }
        return userRepository.save(user);

    }

    //userProject
//    @Override
//    public List<UserEntity> getUsersNotInProject(Long projectId){
//        return userRepository.findUsersNotInProject(projectId);
//    }
    @Override
    public List<UserEntity> findUsersNotInProject(Long projectId) {
        List<Long> userIdsInProject = userProjectRepository.findByProject_ProjectId(projectId)
                .stream()
                .map(userProject -> userProject.getUser().getUserId())
                .collect(Collectors.toList());

        if(userIdsInProject.isEmpty()) {
            return userRepository.findAll();
        }

        return userRepository.findByUserIdNotIn(userIdsInProject);
    }
}
