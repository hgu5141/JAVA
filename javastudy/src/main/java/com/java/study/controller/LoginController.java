package com.java.study.controller;

import com.java.study.dto.request.SignUpRequestDto;
import com.java.study.model.User;
import com.java.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
    private final UserService userService;

    @PostMapping("/sign/up")
    public ResponseEntity<?> uesrSignUp(@RequestBody SignUpRequestDto signupRequestDto) {
        System.out.println("user = " + signupRequestDto);
        User user = userService.onCreateUser(signupRequestDto);
        System.out.println("user = " + user);
        return new ResponseEntity<>(user.fromEntity("계정이 생성되었습니다."), HttpStatus.OK);
    }
}
