package com.example.taskmanager.DTO.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDTO {
    private String email;
    private String password;

    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
