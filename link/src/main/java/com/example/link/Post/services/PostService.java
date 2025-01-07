package com.example.link.Post.services;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import com.example.link.Post.repositories.PostRepository;
import com.example.link.Project.entity.Project;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void write(Post post) {
        Post post1 = Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .authorId(post.getAuthorId())
                .projectId(post.getProjectId())
                .build();
        postRepository.save(post1);
    }

    public PostDto getOnePost(Integer postId) {
        Optional<Post> oPost = this.postRepository.findById( postId );
        if( oPost.isPresent() ){ // 데이터가 존재하면
            // Post 엔티티 -> PostDto로 변환 반환
            Post post = oPost.get(); // Post 획득
            return PostDto.builder()
                    .postId(post.getPostId())
                    .projectId(post.getProjectId())
                    .authorId(post.getAuthorId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createdDate(post.getCreatedDate())
                    .build();
        }throw new EntityNotFoundException("Post not found with id: " + postId); // 예외 처리
    }

    public PostDto updatePost(Integer postId, String title, String content) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        if (title != null && !title.isEmpty()) {
            post.setTitle(title);
        }
        if (content != null && !content.isEmpty()) {
            post.setContent(content);
        }
        post.setCreatedDate(LocalDateTime.now()); // 수정된 날짜로 업데이트
        postRepository.save(post);
        return getOnePost(postId);
    }

    public void delete(PostDto postDto) {
        this.postRepository.delete( postDto.toEntity() );
    }
}
