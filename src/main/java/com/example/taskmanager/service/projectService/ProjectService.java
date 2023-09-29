package com.example.taskmanager.service.projectService;

import com.example.taskmanager.DTO.projectDTO.projectRequestDTO;
import com.example.taskmanager.entity.projectEntity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    ProjectEntity createProject(projectRequestDTO request);
    List<ProjectEntity> getAllProjects();
    ProjectEntity updateProject(Long projectId, projectRequestDTO request);
    void deleteProject(Long projectId);
}
