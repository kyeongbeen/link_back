package com.example.link.Project.entity;

import com.example.link.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class ProjectParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectParticipantsId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "project_id", nullable = true)
    private Project project;

    private String enterDate;
}
