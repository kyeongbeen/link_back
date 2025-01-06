package com.example.link.dto;

import com.example.link.entities.Post;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class PostDto {
    private int postId;
    private int projectId;
    private int authorId;
    private String title;
    private String content;
    private String createdDate;

    public Post toEntity() {
        return Post.builder()
                .postId(this.postId)
                .projectId(this.projectId)
                .authorId(this.authorId)
                .title(this.title)
                .content(this.content)
                .createdDate(this.createdDate)
                .build();
    }
}
