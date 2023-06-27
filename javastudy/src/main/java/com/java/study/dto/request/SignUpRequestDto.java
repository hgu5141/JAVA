package com.java.study.dto.request;

import com.java.study.model.User;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String userName;
    private String email;
    private String nickName;
    private String password;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .email(email)
                .nickName(nickName)
                .password(password)
                .build();
    }
}
