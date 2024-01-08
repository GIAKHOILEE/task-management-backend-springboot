package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.TaskEntity;
import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {


    List<TaskEntity> findAllByProject_ProjectId(Long projectId);
}
