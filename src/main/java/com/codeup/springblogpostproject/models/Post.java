package com.codeup.springblogpostproject.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "posts")
public class Post {

    // Properties
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 500)
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    // Constructors
    public Post() {
    }
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}

