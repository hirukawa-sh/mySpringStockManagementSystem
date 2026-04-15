package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username) {
        // 本来は認証処理（簡易）
        return "redirect:/menu?username=" + username;
    }
}