package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/items")
    public String list(Model model) {
        model.addAttribute("items", repo.findAll());
        return "items";
    }

    @GetMapping("/items/edit/{id}")
    public String createForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", repo.findById(id));
        return "edititem";
    }

    @PostMapping("/items")
    public String create(Item item) {
        repo.save(item);
        return "redirect:/items";
    }
}