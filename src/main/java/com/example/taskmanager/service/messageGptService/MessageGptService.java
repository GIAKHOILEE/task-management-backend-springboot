package com.example.taskmanager.service.messageGptService;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.messageGptEntity.MessageGptEntity;

import java.util.List;

public interface MessageGptService {
    void saveMessage(Long userId, String contentUser, String contentGpt);
    List<MessageGptEntity> getMessagesByUserId(Long userId);
}
