package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

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
        
            if (!model.containsAttribute("loginRequest")) {
                model.addAttribute("loginRequest", new LoginRequestDto("", ""));
            }
        
            return "login";
        }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("loginRequest") LoginRequestDto request,
            BindingResult bindingResult,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
    
        // 入力チェック
        if (bindingResult.hasErrors()) {
            
            redirectAttributes.addFlashAttribute("loginRequest", request);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginRequest",
                    bindingResult);
        
            redirectAttributes.addFlashAttribute("error", "入力エラーがあります");
        
            return "redirect:/";
        }
    
        // 認証
        ServiceResultDto<UsersDto> loginResult =
                loginService.login(request);
    
        if (!loginResult.success()) {
        
            redirectAttributes.addFlashAttribute("loginRequest", request);
            redirectAttributes.addFlashAttribute("error", loginResult.message());
        
            return "redirect:/";
        }
    
        session.setAttribute("loginUser", loginResult.data());
    
        return "redirect:/menu";
    }
}