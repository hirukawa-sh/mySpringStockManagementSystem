package com.example.demo.controller;

import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StockController {

    private final StockRepository repo;

    public StockController(StockRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/stock")
    public String list(Model model) {
        model.addAttribute("stocks", repo.findAll());
        return "stock";
    }
}