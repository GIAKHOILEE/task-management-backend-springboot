package com.example.taskmanager.ServiceImpl.projectServiceImpl;

import com.example.taskmanager.DTO.projectDTO.UserProjectDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.repository.projectRepository.ProjectRepository;
import com.example.taskmanager.repository.projectRepository.TaskAssignmentRepository;
import com.example.taskmanager.repository.projectRepository.UserProjectRepository;
import com.example.taskmanager.service.projectService.UserProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserProjectServiceImpl implements UserProjectService {
    private final UserProjectRepository userProjectRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;
    @Override
    public UserProjectEntity addMemberToProject(UserProjectDTO userProjectDTO) {
        UserEntity user = userRepository.findById(userProjectDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userProjectDTO.getUserId()));

        ProjectEntity project = projectRepository.findById(userProjectDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + userProjectDTO.getProjectId()));

        UserProjectEntity userProject = new UserProjectEntity();
        userProject.setUser(user);
        userProject.setProject(project);
        userProject.setRole(userProjectDTO.getRole());

        return userProjectRepository.save(userProject);
    }

    @Override
    public void removeMemberFromProject(UserProjectDTO userProjectDTO) {
        UserEntity user = userRepository.findById(userProjectDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userProjectDTO.getUserId()));

        ProjectEntity project = projectRepository.findById(userProjectDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + userProjectDTO.getProjectId()));

        UserProjectEntity userProject = userProjectRepository.findByUserAndProject(user, project)
                .orElseThrow(() -> new RuntimeException("User not associated with this project"));

        userProjectRepository.delete(userProject);
    }

    @Override
    public List<UserEntity> findUsersByProjectId(Long projectId){
        List<UserProjectEntity> userProjects = userProjectRepository.findByProject_ProjectId(projectId);

        return userProjects.stream()
                .map(UserProjectEntity::getUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserProjectEntity> findUserProjectsByProjectId(Long projectId){
        return userProjectRepository.findAllByProject_ProjectId(projectId);
    }

    @Override
    public void deleteUserProjectbyId(Long userProjectId) {
        Optional<UserProjectEntity> userProject = userProjectRepository.findById(userProjectId);
        if (userProject.isPresent()) {
            // Xóa tất cả UserProject liên quan
            List<TaskAssignmentEntity> taskAssignments = taskAssignmentRepository.findAllByUserProject_UserProjectId(userProjectId);
            taskAssignmentRepository.deleteAll(taskAssignments);

            userProjectRepository.deleteById(userProjectId);

        } else {
            throw new EntityNotFoundException("No project found with id " + userProjectId);
        }
    }
}
