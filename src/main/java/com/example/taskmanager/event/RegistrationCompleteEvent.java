package com.example.taskmanager.event;

import com.example.taskmanager.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Setter
@Getter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private UserEntity user;
    private String aplicationUrl;

    public RegistrationCompleteEvent(UserEntity user, String aplicationUrl) {
        super(user);
        this.user = user;
        this.aplicationUrl = aplicationUrl;
    }
}
