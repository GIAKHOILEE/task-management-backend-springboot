package com.example.taskmanager.entity.projectEntity;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
//import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;
    @ManyToOne
    @JoinColumn(name = "user_owner_id", referencedColumnName = "user_id")
    private UserEntity owner;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;
    @Column(name = "level")
    private int level;
    @Column(name = "status")
    private String status = "todo";
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public ProjectEntity() {
    }

    public ProjectEntity(long projectId, UserEntity owner, String projectName, String projectDescription, int level, String status, Date startDate, Date endDate) {
        this.projectId = projectId;
        this.owner = owner;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.level = level;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
