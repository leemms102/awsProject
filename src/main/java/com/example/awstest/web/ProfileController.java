package com.example.awstest.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        // env.getActiveProfiles(): 현재 실행중인 ActiveProfile 가져옴: real, oauth, real-db..
        // real, real1, real2 등 중 하나라도 있으면 반환
//
        return "test";
    }
}