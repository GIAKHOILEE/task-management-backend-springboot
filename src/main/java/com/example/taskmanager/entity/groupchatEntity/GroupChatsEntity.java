package com.example.taskmanager.entity.groupchatEntity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "groupchats")
public class GroupChatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupchat_id")
    private long groupchatId;
    @Column(name = "name")
    private String name;
    @Column(name = "create_at")
    private Date createAt;

    public GroupChatsEntity() {
    }

    public GroupChatsEntity(long groupchatId, String name, Date createAt) {
        this.groupchatId = groupchatId;
        this.name = name;
        this.createAt = createAt;
    }

    public long getGroupchatId() {
        return groupchatId;
    }

    public void setGroupchatId(long groupchatId) {
        this.groupchatId = groupchatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
