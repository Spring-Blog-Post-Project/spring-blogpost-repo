package com.codeup.springblogpostproject.controllers;

import com.codeup.springblogpostproject.models.Comment;
import com.codeup.springblogpostproject.models.Post;
import com.codeup.springblogpostproject.models.User;
import com.codeup.springblogpostproject.repositories.PostRepository;
import com.codeup.springblogpostproject.repositories.UserRepository;
import com.codeup.springblogpostproject.utils.Utils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    // Dependency Injection
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    // Constructor
    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    // Get method to show index.html view with all posts added to model
    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = postsDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }

    // Get method to show show.html view with post added to model
    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    // Get method to show create.html view with empty post object added to model
    @GetMapping("/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    // Post method to receive post object and save to database
    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post) {
        User user = usersDao.findById(Utils.currentUserId());
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    // Get method to show edit.html view with post object added to model
    @GetMapping("/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
        User user = usersDao.findById(Utils.currentUserId());
        Post post = postsDao.findById(id);
        if(!user.equals(post.getUser())) {
            return "redirect:/posts";
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    // Post method to receive post object and save to database
    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        User user = usersDao.findById(Utils.currentUserId());
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    // Get method to delete post from database
    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable long id) {
        User user = usersDao.findById(Utils.currentUserId());
        Post post = postsDao.findById(id);
        long UserId = user.getId();
        long PostUserId = post.getUser().getId();
        if (UserId == PostUserId) {
            System.out.println("UserId and PostUserId are equal");
            postsDao.delete(post);
        }
        return "redirect:/posts";
    }

}