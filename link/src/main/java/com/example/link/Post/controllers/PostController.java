package com.example.link.Post.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.entities.Post;
import com.example.link.Post.form.PostForm;
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
        return postService.getAllPost(); // json 형태로 db의 모든 내용 반환
    }

    @PostMapping("/create") // 글 작성하기
    public List<PostDto> create(@RequestBody Post post) {
        postService.write(post);
        return postService.getAllPost();
    }

    @GetMapping("/detail/{postId}") // 글 상세 보기
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("postId") Integer postId) {
        System.out.println("상세보기 : " + postId);
        PostDto post = this.postService.getOnePost(postId);
        List<Reply> replies = replyService.getReplies(postId); // 해당 글에 달린 댓글 리스트 가져오기

        Map<String, Object> response = new HashMap<>();
        response.put("post", post);
        response.put("replies", replies);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/update/{postId}")  // 글 수정하기
    public PostDto update(@PathVariable Integer postId,
                          @RequestParam(required = false) String title,
                          @RequestParam(required = false) String content) {
        return this.postService.updatePost(postId, title, content);
    }

    @GetMapping("/delete/{postId}") // 글 삭제하기
    public List<PostDto> delete(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getOnePost( postId );
        this.postService.delete( postDto );
        return list();
    }

}
