package com.example.link.auth.service;

import com.example.link.auth.dto.UserDto;
import com.example.link.auth.entity.User2;
import com.example.link.auth.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 일반적인 User 테이블과 연관된 비즈니스 로직 처리
 * - 회원가입
 */
@Service
public class UserService2 {
    @Autowired
    private UserRepository2 userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void create(UserDto userDto) {
        // insert, update
        userRepository.save(User2.builder()
                        .email(userDto.getEmail())
                         // 비번 암호화!! -> DI
                        .password( bCryptPasswordEncoder.encode(userDto.getPassword()))
                        .build());
    }
}
