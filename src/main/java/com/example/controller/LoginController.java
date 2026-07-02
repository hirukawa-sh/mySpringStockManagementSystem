package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.entity.*;
import com.example.service.*;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDto("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute LoginRequestDto request,
            HttpSession session,
            Model model) {
        ServiceResult<UsersDto> result = loginService.login(request);

        if (!result.success()) {
            model.addAttribute("error", result.message());
            return "login";
        }
        
        session.setAttribute("loginUser", result.data();
        return "redirect:/menu";
    }
}