package com.example.taskmanager.DTO.responseDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenResponseDTO {
    private String token;

    public TokenResponseDTO(String token) {
        this.token = token;
    }
}
