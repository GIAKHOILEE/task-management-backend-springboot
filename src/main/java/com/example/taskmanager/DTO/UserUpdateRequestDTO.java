package com.example.taskmanager.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserUpdateRequestDTO {
    private String firstname;
    private String lastname;
    private String email;
    private Long phone;
    private String password;
    private String avatar;


}
