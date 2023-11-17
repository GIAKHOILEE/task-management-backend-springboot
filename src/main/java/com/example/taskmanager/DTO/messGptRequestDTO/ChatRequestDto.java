package com.example.taskmanager.DTO.messGptRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequestDto {
    private Long userId;
    private String prompt;
}
