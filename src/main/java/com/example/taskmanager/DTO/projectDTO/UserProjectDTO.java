package com.example.taskmanager.DTO.projectDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserProjectDTO {
    private Long userId;
    private Long projectId;
    private String role = "member";
}
