package com.example.taskmanager.event.listener;

import com.example.taskmanager.entity.UserEntity;
import com.example.taskmanager.event.RegistrationCompleteEvent;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. get new register usser
        UserEntity theUser = event.getUser();
        // 2. create a verification token for user
        String verificationToken = UUID.randomUUID().toString();
        // 3. save the verification token for user
        userService.saveUserVerificationToken(theUser, verificationToken);
        // 4. build the verification url to send the user
        String url = event.getAplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        // 5. send the email
        log.info("Click the link to verify your Registration : {}", url);
    }
}
