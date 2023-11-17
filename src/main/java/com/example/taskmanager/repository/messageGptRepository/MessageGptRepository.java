package com.example.taskmanager.repository.messageGptRepository;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.messageGptEntity.MessageGptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageGptRepository extends JpaRepository<MessageGptEntity, Long> {

//    List<MessageGptEntity> findByUser(UserEntity user);
        List<MessageGptEntity> findByUserId(Long userId);
}