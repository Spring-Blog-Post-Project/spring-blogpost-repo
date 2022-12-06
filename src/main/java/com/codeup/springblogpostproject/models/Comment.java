package com.codeup.springblogpostproject.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    // Properties
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 500)
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // Constructors
    public Comment() {
    }
    public Comment(String body) {
        this.body = body;
    }
    public Comment(String body, User user, Post post) {
        this.body = body;
        this.user = user;
        this.post = post;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
