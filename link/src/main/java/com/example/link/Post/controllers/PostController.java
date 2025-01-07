package com.example.link.Post.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
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

    @GetMapping("/create") // 글 작성하기
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
    @PostMapping("/detail/{postId}") // 글 상세 보기
    public String detail(@PathVariable("postId") Integer postId, Model model) {
        System.out.println("상세보기 : " + postId);
        PostDto post = this.postService.getOnePost(postId);
        model.addAttribute("post", post);
        return "board/post_detail";
    }

    @PostMapping("/update")  // 글 수정하기
    public String update(Post post) {
        return "board/post_update";
    }
    @PostMapping("/delete") // 글 삭제하기
    public String delete(Post post) {
        return "board/post_delete";
    }
}
