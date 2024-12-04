package com.welcome.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeRestController {
    @GetMapping("/welcome")
    public String getwelcomeMsg(){
        String msg="Welcome To Microservices...!!!!";
        return msg;
    }
}
