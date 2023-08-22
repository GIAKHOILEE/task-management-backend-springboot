package com.example.taskmanager.repository.groupchatRepository;

import com.example.taskmanager.entity.groupchatEntity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members,Long> {
}
