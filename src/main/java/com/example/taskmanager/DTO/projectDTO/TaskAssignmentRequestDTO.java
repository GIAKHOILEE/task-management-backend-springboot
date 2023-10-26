package com.example.taskmanager.DTO.projectDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TaskAssignmentRequestDTO {
    private Long taskId;
    private Long userProjectId;
}
