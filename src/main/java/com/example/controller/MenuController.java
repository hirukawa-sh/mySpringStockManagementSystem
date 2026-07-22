package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import com.example.dto.*;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu(HttpSession session, Model model) {
        var login = (UsersDto)session.getAttribute("loginUser");
        model.addAttribute("name", login.name());
        return "menu";
    }
}