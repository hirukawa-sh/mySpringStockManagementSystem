package com.example.demo.controller;

import com.example.demo.repository.SaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SaleController {

    private final SaleRepository repo;

    public SaleController(SaleRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/sales")
    public String list(Model model) {
        model.addAttribute("sales", repo.findAll());
        return "sales";
    }
}