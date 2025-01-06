package com.example.link.User.service;

import com.example.link.User.dto.SignupDTO;
import com.example.link.User.dto.UserDTO;
import com.example.link.User.entity.User;
import com.example.link.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO signup(SignupDTO signupDTO) {
        User user = userRepository.save(User.builder()
                        .userName(signupDTO.getUserName())
                        .email(signupDTO.getEmail())
                        .userPassword(signupDTO.getPassword())
                .build());
        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getUserPassword())
                .build();
    }
}
