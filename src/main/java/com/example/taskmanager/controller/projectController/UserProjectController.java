package com.example.taskmanager.controller.projectController;

import com.example.taskmanager.DTO.projectDTO.UserProjectDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import com.example.taskmanager.service.UserService;
import com.example.taskmanager.service.projectService.UserProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class UserProjectController {
    private final UserProjectService userProjectService;
    private final UserService userService;
    @PostMapping("/add-member")
    public ResponseEntity<?> addMemberToProject(@RequestBody UserProjectDTO userProjectDTO) {
        try {
            userProjectService.addMemberToProject(userProjectDTO);
            return ResponseEntity.ok("Member added successfully to the project");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove-member")
    public ResponseEntity<?> removeMemberFromProject(@RequestBody UserProjectDTO userProjectDTO) {
        try {
            userProjectService.removeMemberFromProject(userProjectDTO);
            return ResponseEntity.ok("Member removed successfully from the project");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{projectId}/user-in-project")
    public ResponseEntity<List<UserEntity>> getUsersOfProject(@PathVariable Long projectId) {
        try {
            List<UserEntity> users = userProjectService.findUsersByProjectId(projectId);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<UserProjectEntity>> getUserProjectsInProject(@PathVariable Long projectId) {
        List<UserProjectEntity> userProjects = userProjectService.findUserProjectsByProjectId(projectId);
        return ResponseEntity.ok(userProjects);
    }
}
