package com.codeup.springblogpostproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Shows splash_page.html template
    @GetMapping("/")
    public String helloWorld() {
        return "splash_page";
    }

    // Shows about.html template
    @GetMapping("/about")
    public String aboutUs(){
        return "about";
    }

}
