package com.example.controller;

import com.example.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("stock")
public class StockController {

    private final ItemRepository repo;

    public StockController(ItemRepository repo) {
        this.repo = repo;
    }

    // 一覧表示
    @GetMapping
    public String stock(Model model){
        model.addAttribute("items", repo.findAllWithStock());
        return "stock";
    }
}