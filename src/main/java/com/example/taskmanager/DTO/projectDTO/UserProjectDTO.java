package com.example.taskmanager.DTO.projectDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserProjectDTO {
    private Long userId;
    private Long projectId;
    private String role = "member";

    public UserProjectDTO() {
    }

    public UserProjectDTO(Long userId, Long projectId, String role) {
        this.userId = userId;
        this.projectId = projectId;
        this.role = role;
    }
}
