package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String password;
    @ColumnDefault("'NORMAL'")
    private String status ="NORMAL"; // NORMAL, BLOCKED

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    public User(String role, String email, String nickname, String password) {
        this.role = Role.of(role);
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User() {}

    public void updateStatusToBlocked() {
        this.status = "BLOCKED";
    }
}
