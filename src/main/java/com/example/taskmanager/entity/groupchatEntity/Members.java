package com.example.taskmanager.entity.groupchatEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Column(name = "usercreate", nullable = false, columnDefinition = "boolean default false")
    private boolean userCreate = false;
    public Members() {
    }

    public Members(Long memberId, UserEntity user, GroupChatsEntity groupChat, boolean userCreate) {
        this.memberId = memberId;
        this.user = user;
        this.groupChat = groupChat;
        this.userCreate = userCreate;
    }
}
