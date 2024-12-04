package com.greet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="welcome")
public interface WelcomeFeignClient {
    @GetMapping("/welcome")
    public String getWelcomeMsg();
}
