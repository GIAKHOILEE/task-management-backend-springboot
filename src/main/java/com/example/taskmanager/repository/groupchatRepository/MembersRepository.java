package com.example.taskmanager.repository.groupchatRepository;

import com.example.taskmanager.entity.groupchatEntity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MembersRepository extends JpaRepository<Members,Long> {
}
