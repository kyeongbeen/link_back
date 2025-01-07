package com.example.link.Reply.controllers;

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
        return null;
    }

    @GetMapping("/create")
    public String create() {
        return null;
    }

    @GetMapping("/update")
    public String update() {
        return null;
    }

    @GetMapping("/delete")
    public String delete() {
        return null;
    }

}
