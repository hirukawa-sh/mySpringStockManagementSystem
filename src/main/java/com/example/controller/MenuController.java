package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "menu";
    }
}