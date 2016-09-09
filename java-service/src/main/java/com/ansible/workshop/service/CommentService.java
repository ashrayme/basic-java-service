package com.ansible.workshop.service;

import com.ansible.workshop.model.Comment;
import com.ansible.workshop.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentsRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }
}