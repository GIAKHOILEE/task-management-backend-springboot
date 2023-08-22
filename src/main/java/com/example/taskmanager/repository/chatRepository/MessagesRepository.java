package com.example.taskmanager.repository.chatRepository;

import com.example.taskmanager.entity.chatEntity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<MessagesEntity,Long> {
}
