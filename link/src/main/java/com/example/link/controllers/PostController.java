package com.example.link.controllers;

import com.example.link.dto.PostDto;
import com.example.link.entities.Post;
import com.example.link.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public List<PostDto> list(){
      return postService.getAllPost(); // json 형태로 db의 모든 내용 반환
    }

    @GetMapping("/create")
    public String create() {
        return "board/post_form";
    }

    @PostMapping("/write")
    public String writeTest(Post post) {
        System.out.println("제목: "+ post.getTitle());
        System.out.println("내용: "+ post.getContent());
        postService.write(post);
        return "board/post_list";
    }
    @PostMapping("/detail/{postId}")
    public String detail(@PathVariable("postId") Integer postId, Model model) {
        System.out.println("상세보기 : " + postId);
        PostDto post = this.postService.getOnePost(postId);
        model.addAttribute("post", post);
        return "board/post_detail";
    }
}
