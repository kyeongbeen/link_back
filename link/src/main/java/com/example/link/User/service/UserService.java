package com.example.link.User.service;

import com.example.link.Project.entity.ProjectParticipants;
import com.example.link.Project.repository.ProjectParticipantsRepository;
import com.example.link.User.dto.SignupDTO;
import com.example.link.User.dto.UserDTO;
import com.example.link.User.dto.UserListDTO;
import com.example.link.User.entity.User;
import com.example.link.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProjectParticipantsRepository projectParticipantsRepository;
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

    public List<UserListDTO> getUserLists(int projectId) {
        List<UserListDTO> userListDTO = new ArrayList<>();
        List<ProjectParticipants> projectparticipantsList = projectParticipantsRepository.findAllByProject_ProjectId(projectId);
        for (ProjectParticipants p : projectparticipantsList) {
            userListDTO.add(UserListDTO.builder()
                    .userId(p.getUser().getUserId())
                    .userName(p.getUser().getUserName())
                    .email(p.getUser().getEmail())
                    .build());
        }
        return userListDTO;
    }
}
