//package com.candidateservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
//        httpSecurity.authorizeRequests().anyRequest().permitAll();
//        return httpSecurity.build();
//
//
//
//
//    }
//}
