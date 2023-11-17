package com.example.taskmanager.ServiceImpl.messageGptServiceImpl;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.entity.messageGptEntity.MessageGptEntity;
import com.example.taskmanager.repository.messageGptRepository.MessageGptRepository;
import com.example.taskmanager.service.messageGptService.MessageGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageGptServiceImpl implements MessageGptService {

    private final MessageGptRepository messageGptRepository;
    public void saveMessage(Long userId, String contentUser, String contentGpt){
        MessageGptEntity message = new MessageGptEntity();
        message.setUserId(userId);
        message.setContentUser(contentUser);
        message.setContentGpt(contentGpt);
        message.setCreatedAt(LocalDateTime.now());

        messageGptRepository.save(message);
    }

    @Override
    public List<MessageGptEntity> getMessagesByUserId(Long userId) {
        return messageGptRepository.findByUserId(userId);
    }
}
