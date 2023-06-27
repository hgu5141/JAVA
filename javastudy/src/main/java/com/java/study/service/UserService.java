package com.java.study.service;

import com.java.study.dto.request.SignInRequestDto;
import com.java.study.dto.request.SignUpRequestDto;
import com.java.study.dto.resoponse.SignInResponseDto;
import com.java.study.model.User;
import com.java.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User onCreateUser(SignUpRequestDto signUpRequestDto) {
        if (userRepository.findByEmail(signUpRequestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 계정입니다.");
        }
        String tt = passwordEncoder.encode(signUpRequestDto.getPassword());
        System.out.println("tt = " + tt);
        Boolean pp = passwordEncoder.matches("pajhlkjhlkjhlkjhlkjhlkhss;lkword", tt);
        signUpRequestDto.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        return userRepository.save(signUpRequestDto.toEntity());
    }

    public User onSingIn(SignInRequestDto signInRequestDto) {
        Optional<User> user = userRepository.findByEmail(signInRequestDto.getEmail());
        if (user.isPresent()) {
            throw  new IllegalArgumentException("존재하지 않는 계정입니다.");
        }
//        Boolean checkPassword = passwordEncoder.matches(user.get().getPassword(), signInRequestDto.get);
//        if (!checkPassword) {
//            throw  new IllegalArgumentException("비밀번호를 확인해주세요.");
//        }
        return User;
    }
}
