package com.example.link.Project.entity;

import com.example.link.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "project_leader_id", nullable = true)
    private User user;

    private String createDate;
}
