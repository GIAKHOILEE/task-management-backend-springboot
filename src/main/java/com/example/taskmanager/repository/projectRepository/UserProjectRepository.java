package com.example.taskmanager.repository.projectRepository;

import com.example.taskmanager.entity.projectEntity.UserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProjectEntity,Long> {
}
