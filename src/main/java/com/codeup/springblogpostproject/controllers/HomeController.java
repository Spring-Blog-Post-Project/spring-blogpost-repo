package com.codeup.springblogpostproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String helloWorld() {
        return "splash_page";
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "about";
    }

}
