package com.example.link.Reply.services;

import com.example.link.Reply.dto.ReplyDto;
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
        List<Reply> replys= replyRepository.findAll();
        List<ReplyDto> replyDtos= new ArrayList<>();
        for (Reply reply : replys) {
            replyDtos.add(ReplyDto.builder()
                    .replyId(reply.getReplyId())
                    .postId(reply.getPostId())
                    .projectId(reply.getProjectId())
                    .content(reply.getContent())
                    .authorName(reply.getAuthorName())
                    .createdDate(reply.getCreatedDate())
                    .build());

        }
        return replys;
    }

    public void write(Integer postId, Reply reply) {
        Reply reply1 = Reply.builder()
                .content(reply.getContent())
                .authorName(reply.getAuthorName())
                .build();
       replyRepository.save(reply1);
    }

    public ReplyDto getReplies(Integer postId) {
        return replyRepository.findByPostId(postId);
    }
    /*
    public String updateReply() {

    }
    */
}
