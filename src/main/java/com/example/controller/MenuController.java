package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import com.example.common.*;
import com.example.dto.*;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu(Model model) {
        return "menu";
    }
}