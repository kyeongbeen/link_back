package com.example.link.User.controller;


import com.example.link.User.dto.SignupDTO;
import com.example.link.User.dto.UserDTO;
import com.example.link.User.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody SignupDTO signupDTO) {
        return new ResponseEntity<>(userService.signup(signupDTO), HttpStatus.OK);
    }

}
