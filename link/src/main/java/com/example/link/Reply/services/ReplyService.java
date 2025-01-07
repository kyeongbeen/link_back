/*
package com.example.link.Reply.services;

import com.example.link.Reply.entity.Reply;
import com.example.link.Reply.repositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAllRelpy() {
        return replyRepository.findAll();
        List<Reply> reply = new ArrayList<>();
        for (Reply reply : getAllRelpy()) {
            reply.add(reply);
        }
    }

    public String updateReply() {
    }
}
*/