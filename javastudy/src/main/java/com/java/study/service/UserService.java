package com.java.study.service;

import com.java.study.dto.request.SignUpRequestDto;
import com.java.study.model.User;
import com.java.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final  Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;
    public User onCreateUser(SignUpRequestDto signUpRequestDto) {
        if (userRepository.findByEmail(signUpRequestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 계정입니다.");
        }
        String tt = pbkdf2PasswordEncoder.encode(signUpRequestDto.getPassword());
        System.out.println("tt = " + tt);
        Boolean pp = pbkdf2PasswordEncoder.matches("pajhlkjhlkjhlkjhlkjhlkhss;lkword", tt);
        System.out.println("pp = " + pp);
        return userRepository.save(signUpRequestDto.toEntity());
    }

    public User onSingIn()
}
