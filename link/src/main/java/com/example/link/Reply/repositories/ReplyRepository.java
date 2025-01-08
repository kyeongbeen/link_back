package com.example.link.Reply.repositories;

import com.example.link.Reply.dto.ReplyDto;
import com.example.link.Reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository  extends JpaRepository<Reply, Integer> {
    ReplyDto findByPostId(Integer postId);

}
