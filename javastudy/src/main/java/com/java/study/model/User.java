package com.java.study.model;

import com.java.study.dto.resoponse.SignUpResponseDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(Long id, String userName, String email, String nickName, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }

    public SignUpResponseDto fromEntity(String message) {
        return SignUpResponseDto.builder()
                .message(message)
                .id(id)
                .userName(userName)
                .email(email)
                .nickName(nickName)
                .build();

    }
}
