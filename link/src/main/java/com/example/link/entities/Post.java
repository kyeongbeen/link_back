package com.example.link.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private int projectId;
    private int authorId;
    @Column(length = 256)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String createdDate;

    @Builder
    public Post(int postId, int projectId, int authorId, String title, String content, String createdDate) {
        this.postId = postId;
        this.projectId = projectId;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }
}
