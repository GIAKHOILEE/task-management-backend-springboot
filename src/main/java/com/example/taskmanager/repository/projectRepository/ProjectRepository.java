package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Long>{
    List<ProjectEntity> findAllByOwner_UserId(Long userId);
}
