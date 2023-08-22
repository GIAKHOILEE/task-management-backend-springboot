package com.example.taskmanager.registration.token;

import com.example.taskmanager.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expiretionTime;
    private static final int EXPIRATION_TIME = 15;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public VerificationToken(String token, UserEntity user) {
        super();
        this.token = token;
        this.user = user;
        this.expiretionTime = this.getTokenExpiretionTime();
    }

    private Date getTokenExpiretionTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
        return new Date(calendar.getTime().getTime());
    }
}
