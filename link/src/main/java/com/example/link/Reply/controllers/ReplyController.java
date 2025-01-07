/*
package com.example.link.Reply.controllers;

import com.example.link.Post.dto.PostDto;
import com.example.link.Reply.dto.ReplyDto;
import com.example.link.Reply.entity.Reply;
import com.example.link.Reply.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/list")
    public List<Reply> list() {
        return replyService.getAllRelpy();
    }

    @GetMapping("/create")
    public String create() {
        replyService.write(reply);
        return replyService.getAllReply();
    }

    @GetMapping("/update")
    public String update() {
        return replyService.updateReply();
    }

/**
    @GetMapping("/delete")
    public List<Reply> delete() {
        ReplyDto replyDto = this.ReplyService.getOneReply( ReplyId );
        this.ReplyService.delete(replyDto);
        return list();
    }


}
*/