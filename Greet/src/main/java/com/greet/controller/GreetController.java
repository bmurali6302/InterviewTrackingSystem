package com.greet.controller;
import com.greet.client.WelcomeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetController {
    @Autowired
    private WelcomeFeignClient welcomeFeignClient;
    public GreetController(WelcomeFeignClient welcomeFeignClient) {
        this.welcomeFeignClient = welcomeFeignClient;
    }
    @GetMapping("/greet")
    public String getGreetMsg(){
        String welcomeMsg = welcomeFeignClient.getWelcomeMsg();
        String greetmsg="Good Morning...!!";
        return greetmsg+welcomeMsg;
    }
}