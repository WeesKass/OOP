package com.example.oop.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main{

    @GetMapping("/login")
    public String showLoginForm() {

        return "views/loginForm";
    }

}