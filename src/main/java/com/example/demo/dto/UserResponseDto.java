package com.example.demo.dto;

import com.example.demo.entity.Role;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String email;
    private String nickname;
    private String role;


    public UserResponseDto(String email, String nickname, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.role = String.valueOf(role);
    }
}
