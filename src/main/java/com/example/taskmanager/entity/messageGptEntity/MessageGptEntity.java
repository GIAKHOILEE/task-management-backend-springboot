package com.example.taskmanager.entity.messageGptEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "messages_gpt")
public class MessageGptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content_user")
    private String contentUser;

    @Column(name = "content_gpt", length = 1000)
    private String contentGpt;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
