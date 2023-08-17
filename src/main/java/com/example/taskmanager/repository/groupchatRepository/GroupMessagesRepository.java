package com.example.taskmanager.repository.groupchatRepository;

import com.example.taskmanager.entity.groupchatEntity.GroupMessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMessagesRepository extends JpaRepository<GroupMessagesEntity,Long> {
}
