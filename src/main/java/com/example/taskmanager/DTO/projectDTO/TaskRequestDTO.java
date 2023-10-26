package com.example.taskmanager.DTO.projectDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class TaskRequestDTO {
    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Integer level;
    private String status;
    private Integer index;
    private Date startDate;
    private Date endDate;
}
