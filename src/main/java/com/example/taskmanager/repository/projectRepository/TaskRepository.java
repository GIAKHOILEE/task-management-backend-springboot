package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
