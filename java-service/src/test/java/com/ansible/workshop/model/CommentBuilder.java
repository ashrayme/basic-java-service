package com.ansible.workshop.model;

public final class CommentBuilder {
    private String email;
    private String comment;

    private CommentBuilder() {
    }

    public static CommentBuilder aComment() {
        return new CommentBuilder();
    }

    public CommentBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CommentBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Comment build() {
        Comment comment = new Comment();
        comment.setEmail(this.email);
        comment.setComment(this.comment);
        return comment;
    }
}
