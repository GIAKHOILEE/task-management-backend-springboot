package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProjectRepository extends JpaRepository<UserProjectEntity,Long> {
    Optional<UserProjectEntity> findByUserAndProject(UserEntity user, ProjectEntity project);
    List<UserProjectEntity> findByProject_ProjectId(Long projectId);

    List<UserProjectEntity> findAllByProject_ProjectId(Long projectId);
}
