package com.example.taskmanager.service.projectService;

import com.example.taskmanager.DTO.projectDTO.UserProjectDTO;
import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;

import java.util.List;

public interface UserProjectService {
    UserProjectEntity addMemberToProject(UserProjectDTO userProjectDTO);
    void removeMemberFromProject(UserProjectDTO userProjectDTO);
    List<UserEntity> findUsersByProjectId(Long projectId);
    List<UserProjectEntity> findUserProjectsByProjectId(Long projectId);
    void deleteUserProjectbyId(Long userProjectId);
}
