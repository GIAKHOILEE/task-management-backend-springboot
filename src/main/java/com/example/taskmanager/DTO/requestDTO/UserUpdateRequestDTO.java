package com.example.taskmanager.DTO.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateRequestDTO {
    private String firstname;
    private String lastname;
    private String email;
    private Long phone;
    private String password;
    private String avatar;

    public UserUpdateRequestDTO() {
    }

    public UserUpdateRequestDTO(String firstname, String lastname, String email, Long phone, String password, String avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.avatar = avatar;
    }
}
