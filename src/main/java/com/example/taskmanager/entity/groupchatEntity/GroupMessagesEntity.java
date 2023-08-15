package com.example.taskmanager.entity.groupchatEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "groupmessages")
public class GroupMessagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupmessage_id")
    private long groupmessageId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "groupchat_id")
    private GroupChatsEntity groupChat;
    @Column(name = "content")
    private String content;
    @Column(name = "create_at")
    private Date createAt;

    public GroupMessagesEntity() {
    }

    public GroupMessagesEntity(long groupmessageId, UserEntity user, GroupChatsEntity groupChat, String content, Date createAt) {
        this.groupmessageId = groupmessageId;
        this.user = user;
        this.groupChat = groupChat;
        this.content = content;
        this.createAt = createAt;
    }

    public long getGroupmessageId() {
        return groupmessageId;
    }

    public void setGroupmessageId(long groupmessageId) {
        this.groupmessageId = groupmessageId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public GroupChatsEntity getGroupChat() {
        return groupChat;
    }

    public void setGroupChat(GroupChatsEntity groupChat) {
        this.groupChat = groupChat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
