package com.example.taskmanager.ServiceImpl.projectServiceImpl;

import com.example.taskmanager.DTO.projectDTO.projectRequestDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import com.example.taskmanager.entity.projectEntity.TaskEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.repository.projectRepository.ProjectRepository;
import com.example.taskmanager.repository.projectRepository.TaskRepository;
import com.example.taskmanager.repository.projectRepository.UserProjectRepository;
import com.example.taskmanager.service.projectService.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserProjectRepository userProjectRepository;
    private final TaskRepository taskRepository;
    @Override
    public ProjectEntity createProject(projectRequestDTO request) {
        UserEntity user = userRepository.findById(request.getOwner())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getOwner()));

        ProjectEntity project = new ProjectEntity();
        project.setOwner(user);
        project.setProjectName(request.getProjectName());
        project.setProjectDescription(request.getProjectDescription());
        project.setLevel(request.getLevel());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());

        return projectRepository.save(project);
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity updateProject(Long projectId, projectRequestDTO request) {
        ProjectEntity existingProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        if (request.getProjectName() != null) {
            existingProject.setProjectName(request.getProjectName());
        }
        if (request.getProjectDescription() != null) {
            existingProject.setProjectDescription(request.getProjectDescription());
        }
        if (request.getLevel() != 0) {
            existingProject.setLevel(request.getLevel());
        }
        if(request.getStatus()!= null){
            existingProject.setStatus(request.getStatus());
        }
        if (request.getStartDate() != null) {
            existingProject.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != null) {
            existingProject.setEndDate(request.getEndDate());
        }
        return projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long projectId) {
        Optional<ProjectEntity> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            // Xóa tất cả UserProject liên quan
            List<UserProjectEntity> userProjects = userProjectRepository.findAllByProject_ProjectId(projectId);
            userProjectRepository.deleteAll(userProjects);

            // Xóa tất cả Task liên quan
            List<TaskEntity> tasks = taskRepository.findAllByProject_ProjectId(projectId);
            taskRepository.deleteAll(tasks);
            // Sau đó xóa Project
            projectRepository.delete(project.get());
        } else {
            throw new EntityNotFoundException("No project found with id " + projectId);
        }
    }

}
