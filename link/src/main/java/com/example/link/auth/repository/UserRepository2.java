package com.example.link.auth.repository;

import com.example.link.auth.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 회원 관련 SQL 지원
 */
public interface UserRepository2 extends JpaRepository<User2, Long> {
    // findBy필드명 메소드 무한확장 -> 커스텀 검색 기능 추가
    Optional<User2> findByEmail(String usernameEmail);
}
