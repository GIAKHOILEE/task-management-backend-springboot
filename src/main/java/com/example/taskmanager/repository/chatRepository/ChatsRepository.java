package com.example.taskmanager.repository.chatRepository;

import com.example.taskmanager.entity.chatEntity.ChatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatsRepository extends JpaRepository<ChatsEntity, Long> {
}
