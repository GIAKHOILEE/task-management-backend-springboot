package com.example.taskmanager.entity.projectEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "taskassignments")
public class TaskAssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private long assignmentId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user_project_id")
    private UserProjectEntity userProject;

    public TaskAssignmentEntity() {
    }

    public TaskAssignmentEntity(long assignmentId, TaskEntity task, UserProjectEntity userProject) {
        this.assignmentId = assignmentId;
        this.task = task;
        this.userProject = userProject;
    }
}
