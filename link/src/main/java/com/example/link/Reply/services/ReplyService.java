package com.example.link.Reply.services;


import com.example.link.Reply.repositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
}
