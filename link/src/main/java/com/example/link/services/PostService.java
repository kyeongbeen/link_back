package com.example.link.services;

import com.example.link.dto.PostDto;
import com.example.link.entities.Post;
import com.example.link.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            postDtos.add(PostDto.builder()
                    .postId(post.getPostId())
                    .projectId(post.getProjectId())
                    .authorId(post.getAuthorId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createdDate(post.getCreatedDate())
                    .build());
        }

        return postDtos;
    }
}
