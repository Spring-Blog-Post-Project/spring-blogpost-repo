package com.codeup.springblogpostproject.controllers;

import com.codeup.springblogpostproject.models.User;
import com.codeup.springblogpostproject.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // Dependency Injection
    private final UserRepository usersDao;
    private final PasswordEncoder passwordEncoder;

    // Constructor
    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    // Get method to show registration.html with empty user object added to model
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "/registration";
    }

    // Post method to save new user to database after hashing password
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);
        return "redirect:/posts/create";
    }
}