package com.example.taskmanager.repository.groupchatRepository;

import com.example.taskmanager.entity.groupchatEntity.GroupMessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface GroupMessagesRepository extends JpaRepository<GroupMessagesEntity,Long> {
}
