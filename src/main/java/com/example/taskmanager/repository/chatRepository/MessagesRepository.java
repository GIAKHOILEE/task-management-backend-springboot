package com.example.taskmanager.repository.chatRepository;

import com.example.taskmanager.entity.chatEntity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface MessagesRepository extends JpaRepository<MessagesEntity,Long> {
}
