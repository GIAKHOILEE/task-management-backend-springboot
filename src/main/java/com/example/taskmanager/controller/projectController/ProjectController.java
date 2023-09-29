package com.example.taskmanager.controller.projectController;

import com.example.taskmanager.DTO.projectDTO.projectRequestDTO;
import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import com.example.taskmanager.service.projectService.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectEntity> createProject(@RequestBody projectRequestDTO request) {
        ProjectEntity savedProject = projectService.createProject(request);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
    @GetMapping("/getAllProject")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @PatchMapping("/updateProject")
    public ResponseEntity<ProjectEntity> updateProject(
            @RequestHeader("projectId") Long projectId,
            @RequestBody projectRequestDTO request) {
        ProjectEntity updatedProject = projectService.updateProject(projectId, request);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProject")
    public ResponseEntity<?> deleteProject(@RequestHeader("projectId") Long projectId) {
        try {
            projectService.deleteProject(projectId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the project", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
