package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.TaskAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignmentEntity, Long> {

    List<TaskAssignmentEntity> findByTask_Project_ProjectId(Long projectId);
    List<TaskAssignmentEntity> findAllByTask_TaskId(Long taskId);
    List<TaskAssignmentEntity> findAllByUserProject_UserProjectId(Long userProjectId);

}
