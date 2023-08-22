package com.example.taskmanager.repository.groupchatRepository;

import com.example.taskmanager.entity.groupchatEntity.GroupChatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupChatsRepository extends JpaRepository<GroupChatsEntity,Long> {
}
