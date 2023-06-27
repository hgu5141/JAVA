package com.java.study.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
    @Bean
    public Pbkdf2PasswordEncoder encoder() {
        return new Pbkdf2PasswordEncoder("1214f02c-ed05-401a-b527-97c54c9dbc91", 10, 10, 10);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/api/sign/up")
                .permitAll());
        http.csrf().disable();
        return http.build();

    }
}