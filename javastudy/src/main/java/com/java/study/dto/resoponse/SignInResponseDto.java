package com.java.study.dto.resoponse;

import com.java.study.model.User;

public class SignInResponseDto {
    String userName;
    String nickName;
    String email;
    public User toEntity() {
        return User.builder()
                .userName(userName)
                .email(email)
                .nickName(nickName)
                .build();
    }
}
