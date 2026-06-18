package com.example.controller;

import com.example.entity.Sales;
import com.example.repository.SalesRepository;
import com.example.repository.SalesDetailRepository;
import com.example.dto.SalesDto;
import com.example.dto.SalesDetailDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SalesRepository repo;

    public SalesController(SalesRepository repo) {
        this.repo = repo;
    }

    // 一覧
    @GetMapping
    public String list(Model model) {
        model.addAttribute("sales", repo.findAll());
        return "sales";
    }
    
    // 新規
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("sales", repo.findAll());
        return "editsales";
    }
    
    // 編集
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("sales", repo.findById(id).orElse(new Sales());
        return "editsales";
    }
}