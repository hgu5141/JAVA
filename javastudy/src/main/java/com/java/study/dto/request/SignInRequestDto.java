package com.java.study.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequestDto {
    private String userName;
    private String email;
    private String nickName;
}
