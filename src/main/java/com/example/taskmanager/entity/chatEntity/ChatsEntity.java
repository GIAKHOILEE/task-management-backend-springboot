package com.example.taskmanager.entity.chatEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "chats")
public class ChatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private long chatId;
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private UserEntity user1;
    @ManyToOne
    @JoinColumn(name = "user2_id")
    private UserEntity user2;

    public ChatsEntity() {
    }

    public ChatsEntity(long chatId, UserEntity user1, UserEntity user2) {
        this.chatId = chatId;
        this.user1 = user1;
        this.user2 = user2;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public UserEntity getUser1() {
        return user1;
    }

    public void setUser1(UserEntity user1) {
        this.user1 = user1;
    }

    public UserEntity getUser2() {
        return user2;
    }

    public void setUser2(UserEntity user2) {
        this.user2 = user2;
    }
}
