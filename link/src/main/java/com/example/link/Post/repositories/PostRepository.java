package com.example.link.Post.repositories;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

    PostDto getPostsByPostId(int postId);
}
