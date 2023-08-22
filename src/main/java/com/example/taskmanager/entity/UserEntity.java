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
    @Column(name = "phonenumber")
    private long phonenumber;
    @Column(name = "password")
    private String password;

    public UserEntity() {
    }

    public UserEntity(long userId, String firstname, String lastname, String email, long phonenumber, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }
}
