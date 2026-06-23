package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dto.view.LoginViewDto;
import com.example.entity.Users;
import com.example.repository.UsersRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UsersRepository usersRepository;

    @GetMapping("/")
    public String loginForm(Model model) {

        model.addAttribute("loginViewDto", new LoginViewDto());

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute LoginViewDto loginViewDto,
            HttpSession session,
            Model model) {

        Optional<Users> usersOpt =
                usersRepository.findByName(loginViewDto.getUsername());

        if (usersOpt.isEmpty()) {
            model.addAttribute("error", "ユーザーが存在しません");
            return "login";
        }

        Users users = usersOpt.get();

        if (!users.getPassword().equals(loginViewDto.getPassword())) {
            model.addAttribute("error", "パスワードが違います");
            return "login";
        }

        session.setAttribute("loginUser", users);

        return "redirect:/menu";
    }
}