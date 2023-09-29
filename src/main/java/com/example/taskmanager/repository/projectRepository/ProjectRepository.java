package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Long>{
}
