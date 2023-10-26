package com.example.taskmanager.service.projectService;

import com.example.taskmanager.DTO.projectDTO.TaskAssignmentRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;

import java.util.List;

public interface TaskAssignmentService {
    void createAssignment(TaskAssignmentRequestDTO request);
    void deleteAssignment(Long assignmentId);

    List<TaskAssignmentEntity> findTaskAssigmentByTaskId(Long taskId);
    List<TaskAssignmentEntity> getAllAssignmentsByProjectId(Long projectId);
}
