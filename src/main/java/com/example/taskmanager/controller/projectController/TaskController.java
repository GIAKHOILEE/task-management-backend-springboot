package com.example.taskmanager.controller.projectController;

import com.example.taskmanager.DTO.projectDTO.TaskRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import com.example.taskmanager.service.projectService.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
        try {
            TaskEntity createdTask = taskService.createTask(task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-task")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        List<TaskEntity> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/get-by-idproject")
    public ResponseEntity<List<TaskEntity>> getTasksInProject(@PathVariable Long projectId) {
        List<TaskEntity> tasks = taskService.findTasksByProjectId(projectId);
        return ResponseEntity.ok(tasks);
    }

    @PatchMapping("/update")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskRequestDTO request) {
        try {
            TaskEntity updatedTask = taskService.updateTask(request);
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        try {
            taskService.deleteTask(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
