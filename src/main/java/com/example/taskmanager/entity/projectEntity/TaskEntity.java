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
    private ProjectEntity project;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description")
    private String taskDescription;
    @Column(name = "level")
    private int level;
    @Column(name = "status")
    private String status = "todo";
//    @Column(name = "index")
//    private Integer index;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public TaskEntity() {
    }

    public TaskEntity(long taskId, ProjectEntity project, String taskName, String taskDescription, int level, String status, int index, Date startDate, Date endDate) {
        this.taskId = taskId;
        this.project = project;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.level = level;
        this.status = status;
//        this.index = index;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
