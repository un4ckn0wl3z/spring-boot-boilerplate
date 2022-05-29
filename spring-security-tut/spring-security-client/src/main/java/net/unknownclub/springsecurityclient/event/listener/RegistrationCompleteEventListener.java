package net.unknownclub.springsecurityclient.event.listener;

import lombok.extern.slf4j.Slf4j;
import net.unknownclub.springsecurityclient.entity.User;
import net.unknownclub.springsecurityclient.event.RegistrationCompleteEvent;
import net.unknownclub.springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the Verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // Send mail
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        // send verification email
        log.info("Click the link to verify your account: {}", url);
    }
}
