package com.java.study.dto.resoponse;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private String message;
    private Long id;
    private String email;
    private String userName;
    private String nickName;

    @Builder
    public SignUpResponseDto(String message, Long id, String email, String userName, String nickName) {
        this.message = message;
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.nickName = nickName;
    }
}
