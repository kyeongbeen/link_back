
package com.example.link.Reply.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Reply.dto.ReplyDto;
import com.example.link.Reply.entity.Reply;
import com.example.link.Reply.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/list")
    public List<Reply> list() {
        return replyService.getAllRelpy();
    }


    @PostMapping("/detail/{postId}")
    public ResponseEntity<ReplyDto> createReply(@PathVariable("postId") Integer postId, @RequestBody Reply reply) {
        replyService.write(postId, reply);
        ReplyDto replies = replyService.getReplies(postId);
        return ResponseEntity.ok(replies);
    }
/*
    @GetMapping("/update")
    public String update() {
        return replyService.updateReply();
    }
    */

    /**
    @GetMapping("/delete")
    public List<Reply> delete() {
        ReplyDto replyDto = this.ReplyService.getOneReply( ReplyId );
        this.ReplyService.delete(replyDto);
        return list();
    }
    */

}
