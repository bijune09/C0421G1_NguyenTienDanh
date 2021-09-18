package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping
    public String homepage(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login/login-page";
    }
}
