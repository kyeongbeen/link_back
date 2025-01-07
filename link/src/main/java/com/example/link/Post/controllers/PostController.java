package com.example.link.Post.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import com.example.link.Post.form.PostForm;
import com.example.link.Post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list") // 게시물 목록
    public List<PostDto> list(){
        return postService.getAllPost(); // json 형태로 db의 모든 내용 반환
    }

    @PostMapping("/create") // 글 작성하기
    public List<PostDto> create(Post post) {
        postService.write(post);
        return postService.getAllPost();
    }

    @GetMapping("/detail/{postId}") // 글 상세 보기
    public PostDto detail(@PathVariable("postId") Integer postId, Model model) {
        System.out.println("상세보기 : " + postId);
        PostDto post = this.postService.getOnePost(postId);
        model.addAttribute("post", post);
        return post;
    }

    @PostMapping("/update")  // 글 수정하기
    public PostDto update(@RequestBody PostDto post) {
        return this.postService.updatePost(post);
    }

    @GetMapping("/delete/{postId}") // 글 삭제하기
    public List<PostDto> delete(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getOnePost( postId );
        this.postService.delete( postDto );
        return list();
    }

}
