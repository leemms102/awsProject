package com.example.awstest.config.auth.dto;

import com.example.awstest.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
// 그냥 User Class 사용하면 error. 세션에 사용자 정보 저장하는 dto
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}