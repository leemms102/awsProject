package com.example.awstest.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // email을 보고 신규 사용자인지 기존 사용자인지 판단
    Optional <User> findByEmail(String email);
}
