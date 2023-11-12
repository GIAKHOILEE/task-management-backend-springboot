package com.example.taskmanager.ServiceImpl.projectServiceImpl;

import com.example.taskmanager.DTO.projectDTO.TaskAssignmentRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;
import com.example.taskmanager.entity.projectEntity.TaskEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import com.example.taskmanager.repository.projectRepository.TaskAssignmentRepository;
import com.example.taskmanager.repository.projectRepository.TaskRepository;
import com.example.taskmanager.repository.projectRepository.UserProjectRepository;
import com.example.taskmanager.service.projectService.TaskAssignmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    private final TaskRepository taskRepository;
    private final UserProjectRepository userProjectRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;

    @Override
    public void createAssignment(TaskAssignmentRequestDTO request) {
        TaskEntity task = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + request.getTaskId()));
        UserProjectEntity userProject = userProjectRepository.findById(request.getUserProjectId())
                .orElseThrow(() -> new RuntimeException("UserProject not found with id: " + request.getUserProjectId()));

        TaskAssignmentEntity assignment = new TaskAssignmentEntity();
        assignment.setTask(task);
        assignment.setUserProject(userProject);

        taskAssignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignmentEntity> findTaskAssigmentByTaskId(Long taskId) {
        return taskAssignmentRepository.findAllByTask_TaskId(taskId);
    }

    @Override
    public void deleteAssignment(Long assignmentId) {
        if (!taskAssignmentRepository.existsById(assignmentId)) {
            throw new EntityNotFoundException("No assignment found with id " + assignmentId);
        }
        taskAssignmentRepository.deleteById(assignmentId);
    }

    @Override
    public List<TaskAssignmentEntity> getAllAssignmentsByProjectId(Long projectId) {
        return taskAssignmentRepository.findByTask_Project_ProjectId(projectId);
    }

    @Override
    public List<TaskAssignmentEntity> getAllAssignmentsByUserProjectId(Long userProjectId){
        return taskAssignmentRepository.findAllByUserProject_UserProjectId(userProjectId);
    }
}
