package com.example.link.Reply.controllers;

import com.example.link.Post.dto.PostDto;
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
    private PostService postService;

    @GetMapping("/list") // 전체 댓글 출력
    public List<Reply> list() {
        return replyService.getAllRelpy();
    }

    @PostMapping("/create/{postId}") // 댓글 생성하기
    public ResponseEntity<List<Reply>> createReply(@PathVariable("postId") Integer postId, @RequestBody Reply reply) {
        replyService.write(postId, reply);
        List<Reply> replies = replyService.getReplies(postId);
        return ResponseEntity.ok(replies);
    }

    @PostMapping("/update/{replyId}") // 댓글 수정하기
    public ReplyDto update(@PathVariable int replyId, @RequestParam(required = false) String content) {
        return replyService.updateReply(replyId, content);
    }

    @PostMapping("/delete/{replyId}") // 댓글 삭제하기
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer replyId) {
        ReplyDto replyDto = this.replyService.getOneReply(replyId);

        this.replyService.delete(replyDto);

        Integer postId = replyDto.getPostId();
        PostDto post = this.postService.getOnePost(postId);
        List<Reply> replies = replyService.getReplies(replyId);

        Map<String, Object> response = new HashMap<>();
        response.put("post", post);
        response.put("replies", replies);

        return ResponseEntity.ok(response);
    }

}
