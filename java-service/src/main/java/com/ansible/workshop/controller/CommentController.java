package com.ansible.workshop.controller;

import com.ansible.workshop.model.Comment;
import com.ansible.workshop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.ansible.workshop.model.Comment.emptyComment;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String comments(Model model) {
        model.addAttribute("comment", emptyComment());
        return "comment";
    }

    @PostMapping
    public String comment(@ModelAttribute Comment comment) {
        commentService.saveComment(comment);
        return "comment";
    }
}