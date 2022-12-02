package com.codeup.springblogpostproject.controllers;

import com.codeup.springblogpostproject.models.Post;
import com.codeup.springblogpostproject.models.User;
import com.codeup.springblogpostproject.repositories.PostRepository;
import com.codeup.springblogpostproject.repositories.UserRepository;
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

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }
//^^


    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts = postsDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }


    @GetMapping("/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long UserId = user.getId();
        user = usersDao.findById(UserId);
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

//    Refactor your PostController and create form to implement form model binding.

    @GetMapping("/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        long UserId = user.getId();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/delete")
    public String showDeletePostForm(@PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postsDao.findById(id);
        if (user.getId() == post.getUser().getId()) {
            postsDao.delete(post);
        }
        return "redirect:/posts";
    }



}
