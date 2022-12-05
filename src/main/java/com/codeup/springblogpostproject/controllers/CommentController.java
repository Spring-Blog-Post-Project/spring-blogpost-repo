package com.codeup.springblogpostproject.controllers;

import com.codeup.springblogpostproject.models.Comment;
import com.codeup.springblogpostproject.models.Post;
import com.codeup.springblogpostproject.models.User;
import com.codeup.springblogpostproject.repositories.CommentRepository;
import com.codeup.springblogpostproject.repositories.PostRepository;
import com.codeup.springblogpostproject.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    // Dependency Injection

    private final PostRepository postsDao;

    private final CommentRepository commentsDao;
    private final UserRepository usersDao;

    public CommentController(CommentRepository commentsDao, UserRepository usersDao, PostRepository postsDao) {
        this.commentsDao = commentsDao;
        this.usersDao = usersDao;
        this.postsDao = postsDao;
    }

    @GetMapping("/create")
    public String createComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "/comments/create";
    }

    @PostMapping("/{id}/create")
    public String addComment(@ModelAttribute Comment comment) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long UserId = user.getId();
        user = usersDao.findById(UserId);
        comment.setUser(user);
        commentsDao.save(comment);
        return "redirect:/posts";
    }

    

}
