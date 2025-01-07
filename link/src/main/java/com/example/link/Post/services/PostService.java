package com.example.link.Post.services;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import com.example.link.Post.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        postRepository.save(post);
    }

    public PostDto getOnePost(Integer postId) {
        Optional<Post> oPost = this.postRepository.findById( postId );
        if( oPost.isPresent() ){ // 데이터가 존재하면
            // Post 엔티티 -> PostDto로 변환 반환
            Post post = oPost.get(); // Post 획득
            return PostDto.builder()
                    .postId(post.getPostId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createdDate(post.getCreatedDate())
                    //.reviews(post.getReviews())
                    .build();
        }
        return null;
    }
}
