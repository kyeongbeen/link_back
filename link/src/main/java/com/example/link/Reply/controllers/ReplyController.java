package com.example.link.Reply.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Post.repositories.PostRepository;
import com.example.link.Post.services.PostService;
import com.example.link.Reply.dto.ReplyDto;
import com.example.link.Reply.entity.Reply;
import com.example.link.Reply.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/list") // 전체 댓글 출력
    public List<Reply> list() {
        return replyService.getAllRelpy();
    }

    @PostMapping("/create/{postId}") // 댓글 생성하기
    public ResponseEntity<List<Reply>> createReply(@PathVariable("postId") Integer postId, @RequestBody Reply reply) {
        return replyService.write(postId, reply);
    }

    @PostMapping("/update/{replyId}") // 댓글 수정하기
    public ReplyDto update(@PathVariable int replyId, @RequestParam(required = false) String content) {
        return replyService.updateReply(replyId, content);
    }

    @PostMapping("/delete/{replyId}") // 댓글 삭제하기
    public String delete(@PathVariable Integer replyId) {
        return replyService.delete(replyId);
    }

}
