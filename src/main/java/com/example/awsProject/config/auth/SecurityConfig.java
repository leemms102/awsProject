package com.example.awsProject.config.auth;

import com.example.awsProject.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    // 권한대상 주소
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    // user만 /api/v1/** api 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        // 로그아웃 성공 시 이동
                        .logoutSuccessUrl("/")
                .and()
                    // 진업점
                    .oauth2Login()
                        // OAuth2 로그인 성공 후 사용자 정보 가져올 떄 설정
                        .userInfoEndpoint()
                            // 소셜 로그인 성공 시 진행할 UserService 인터페이스 구현체 등록. 소셜 서비스에서 사용자 정보 가져온 상태에서 추가로 진행하도록 명시
                            .userService(customOAuth2UserService);
    }
}