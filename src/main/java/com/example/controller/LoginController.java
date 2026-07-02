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
        model.addAttribute("request", new LoginRequestDto("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("loginRequest") LoginRequestDto request,
            BindingResult bindingResult,
            HttpSession session,
            Model model) {
    
        // 入力チェック
        if (bindingResult.hasErrors()) {
            return "login";
        }
    
        // 認証
        ServiceResultDto<UsersDto> loginResult =
                loginService.login(request);
    
        if (!loginResult.success()) {
            model.addAttribute("error", loginResult.message());
            return "login";
        }
    
        session.setAttribute("loginUser", loginResult.data());
    
        return "redirect:/menu";
    }
}