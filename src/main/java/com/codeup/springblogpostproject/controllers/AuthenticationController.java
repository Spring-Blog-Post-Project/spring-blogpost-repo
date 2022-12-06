package com.codeup.springblogpostproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    // Shows login.html template
    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

}
