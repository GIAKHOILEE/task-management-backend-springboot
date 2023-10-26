package com.example.taskmanager.controller.projectController;

import com.example.taskmanager.DTO.projectDTO.TaskAssignmentRequestDTO;
import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;
import com.example.taskmanager.service.projectService.TaskAssignmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks")
public class TaskAssignmentController {
    private final TaskAssignmentService taskAssignmentService;

    @PostMapping("/assign-task")
    public ResponseEntity<?> assignTask(@RequestBody TaskAssignmentRequestDTO request) {
        try {
            taskAssignmentService.createAssignment(request);
            return ResponseEntity.ok("Task assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/find-all-assign-by-taskid/{taskId}")
    public ResponseEntity<List<TaskAssignmentEntity>> getTaskAssignmentsByTaskId(@PathVariable Long taskId) {
        List<TaskAssignmentEntity> taskAssignments = taskAssignmentService.findTaskAssigmentByTaskId(taskId);
        return ResponseEntity.ok(taskAssignments);
    }

    @DeleteMapping("/assign/delete/{assignmentId}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long assignmentId) {
        try {
            taskAssignmentService.deleteAssignment(assignmentId);
            return ResponseEntity.ok("Assignment deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the assignment");
        }
    }

    @GetMapping("/find-all-assign-by-projectid")
    public ResponseEntity<List<TaskAssignmentEntity>> getAllAssignmentsByProjectId(@PathVariable Long projectId) {
        List<TaskAssignmentEntity> assignments = taskAssignmentService.getAllAssignmentsByProjectId(projectId);
        return ResponseEntity.ok(assignments);
    }
}
