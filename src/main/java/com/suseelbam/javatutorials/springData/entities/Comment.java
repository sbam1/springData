package com.suseelbam.javatutorials.springData.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String comment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToOne
    private Users commenter;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getCommenter() {
        return commenter;
    }

    public void setCommenter(Users commenter) {
        this.commenter = commenter;
    }
}
