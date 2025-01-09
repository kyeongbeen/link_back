package com.example.link.Post.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import com.example.link.Post.form.PostForm;
import com.example.link.Post.repositories.PostRepository;
import com.example.link.Post.services.PostService;
import com.example.link.Reply.entity.Reply;
import com.example.link.Reply.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("/list") // 게시물 목록
    public List<PostDto> list(){
        return postService.getAllPost();
    }

    @PostMapping("/create") // 글 작성하기
    public List<PostDto> create(@RequestBody PostDto postDto) {
        return postService.write(postDto);
    }

    @GetMapping("/detail/{postId}") // 글 상세 보기 + 글에 달린 댓글 보기
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("postId") Integer postId) {
        return postService.detail(postId);
    }

    @PostMapping("/update/{postId}")  // 글 수정하기
    public PostDto update(@PathVariable Integer postId, @RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return this.postService.updatePost(postId, title, content);
    }

    @GetMapping("/delete/{postId}") // 글 삭제하기
    public String delete(@PathVariable Integer postId) {
        return postService.delete(postId);
    }

}
