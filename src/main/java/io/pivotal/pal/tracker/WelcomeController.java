package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class WelcomeController {


    private String messageStr;

    @GetMapping("/")
    public String sayHello() {
        return messageStr;
    }

    public WelcomeController(@Value("${WELCOME_MESSAGE}")String str)
    {
        messageStr=str;
    }

}