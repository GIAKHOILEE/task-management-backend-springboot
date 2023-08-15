package com.example.taskmanager.entity.groupchatEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "groupchat_id")
    private GroupChatsEntity groupChat;

    public Members() {
    }

    public Members(Long memberId, UserEntity user, GroupChatsEntity groupChat) {
        this.memberId = memberId;
        this.user = user;
        this.groupChat = groupChat;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
}
