package com.example.taskmanager.entity.projectEntity;
import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "userprojects")
public class UserProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_project_id")
    private long userProjectId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private ProjectEntity project;
    @Column(name = "role")
    private String role;

    public UserProjectEntity() {
    }

    public UserProjectEntity(long userProjectId, UserEntity user, ProjectEntity project, String role) {
        this.userProjectId = userProjectId;
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
