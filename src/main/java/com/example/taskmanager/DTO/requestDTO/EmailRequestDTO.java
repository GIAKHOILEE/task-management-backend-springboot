package com.example.taskmanager.DTO.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailRequestDTO {
    private String email;
    private int verificationCode;

    public EmailRequestDTO() {
    }

    public EmailRequestDTO(String email, int verificationCode) {
        this.email = email;
        this.verificationCode = verificationCode;
    }
}
