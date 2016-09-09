package com.ansible.workshop.controller;

import com.ansible.workshop.model.Comment;
import com.ansible.workshop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.ansible.workshop.model.Comment.emptyComment;

@Controller
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
        model.addAttribute("allComments", commentService.getAllComments());
        return "comment";
    }

    @PostMapping
    public String comment(@ModelAttribute Comment comment, Model model) {
        commentService.saveComment(comment);
        model.addAttribute("comment", emptyComment());
        model.addAttribute("allComments", commentService.getAllComments());
        return "comment";
    }
}