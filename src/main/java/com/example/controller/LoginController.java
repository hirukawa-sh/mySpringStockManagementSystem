package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dto.view.LoginViewDto;
import com.example.entity.User;
import com.example.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String loginForm(Model model) {

        model.addAttribute("loginViewDto", new LoginViewDto());

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute LoginDto loginDto,
            HttpSession session,
            Model model) {

        Optional<User> userOpt =
                userRepository.findByName(loginViewDto.getUsername());

        if (userOpt.isEmpty()) {
            model.addAttribute("error", "ユーザーが存在しません");
            return "login";
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(loginViewDto.getPassword())) {
            model.addAttribute("error", "パスワードが違います");
            return "login";
        }

        session.setAttribute("loginUser", user);

        return "redirect:/menu";
    }
}