package com.ansible.workshop.controller;

import com.ansible.workshop.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @GetMapping
    public String comments(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment";
    }

    @PostMapping
    public String comment(@ModelAttribute Comment comment) {
        return "comment";
    }
}