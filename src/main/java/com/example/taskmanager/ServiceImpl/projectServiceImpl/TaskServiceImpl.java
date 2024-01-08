package com.example.taskmanager.ServiceImpl.projectServiceImpl;

import com.example.taskmanager.DTO.projectDTO.TaskRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;
import com.example.taskmanager.entity.projectEntity.TaskEntity;
import com.example.taskmanager.repository.projectRepository.TaskAssignmentRepository;
import com.example.taskmanager.repository.projectRepository.TaskRepository;
import com.example.taskmanager.service.projectService.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;
    @Override
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll() ;
    }

    @Override
    public List<TaskEntity> findTasksByProjectId(Long projectId) {
        return taskRepository.findAllByProject_ProjectId(projectId);
    }

    @Override
    public TaskEntity updateTask(TaskRequestDTO request) {
        TaskEntity existingTask = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + request.getTaskId()));

        if (request.getTaskName() != null) {
            existingTask.setTaskName(request.getTaskName());
        }
        if (request.getTaskDescription() != null) {
            existingTask.setTaskDescription(request.getTaskDescription());
        }
        if (request.getLevel() != null) {
            existingTask.setLevel(request.getLevel());
        }
        if (request.getStatus() != null) {
            existingTask.setStatus(request.getStatus());
        }
//        if (request.getIndex() != null) {
//            existingTask.setIndex(request.getIndex());
//        }
        if (request.getStartDate() != null) {
            existingTask.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != null) {
            existingTask.setEndDate(request.getEndDate());
        }

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<TaskEntity> task = taskRepository.findById(taskId);

        if (task.isPresent()) {
            // Xóa tất cả taskAssignee liên quan
            List<TaskAssignmentEntity> taskAssignment = taskAssignmentRepository.findAllByTask_TaskId(taskId);
            taskAssignmentRepository.deleteAll(taskAssignment);

            // xóa task
            taskRepository.delete(task.get());
        } else {
            throw new EntityNotFoundException("No project found with id " + taskId);
        }
    }
}
