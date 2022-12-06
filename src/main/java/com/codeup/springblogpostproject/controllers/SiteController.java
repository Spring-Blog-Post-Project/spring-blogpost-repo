package com.codeup.springblogpostproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {


    // Shows about.html template
    @GetMapping("/about")
    public String aboutUs(){
        return "site/about";
    }

    // Shows contact.html template
    @GetMapping("/contact")
    public String contactUs() {
        return "site/contact";
    }
}
