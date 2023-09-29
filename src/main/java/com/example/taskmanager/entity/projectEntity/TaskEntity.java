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
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private ProjectEntity projectId;
    @ManyToOne
    @JoinColumn(name = "user_assignee_id", referencedColumnName = "user_id")
    private UserEntity assignee;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description")
    private String taskDescription;
    @Column(name = "level")
    private int level;
    @Column(name = "status")
    private String status = "todo";
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public TaskEntity() {
    }

    public TaskEntity(long taskId, ProjectEntity projectId, UserEntity assignee, String taskName, String taskDescription, int level, String status, Date startDate, Date endDate) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.assignee = assignee;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.level = level;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
