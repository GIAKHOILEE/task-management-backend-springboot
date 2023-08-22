package com.example.taskmanager.entity.chatEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "messages")
public class MessagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private ChatsEntity chats;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private Date timestamp;

    public MessagesEntity() {
    }

    public MessagesEntity(long messageId, ChatsEntity chats, UserEntity sender, String content, Date timestamp) {
        this.messageId = messageId;
        this.chats = chats;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public ChatsEntity getChats() {
        return chats;
    }

    public void setChats(ChatsEntity chats) {
        this.chats = chats;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
