package com.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @NaturalId
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;

    public UserEntity() {
    }

    public UserEntity(long userId, String firstname, String lastname, String email, String password, String avatar) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }

    public UserEntity(long userId, String firstname, String lastname, String email, Long phone, String password, String avatar) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.avatar = avatar;
    }
}
