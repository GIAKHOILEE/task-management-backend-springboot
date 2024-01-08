package com.example.taskmanager.service.projectService;

import com.example.taskmanager.DTO.projectDTO.TaskRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskEntity;

import java.util.List;

public interface TaskService {
    TaskEntity createTask(TaskEntity task);
    List<TaskEntity> getAllTasks();
    TaskEntity updateTask(TaskRequestDTO request);
    void deleteTask(Long taskId);

    List<TaskEntity> findTasksByProjectId(Long projectId);
}
