package com.example.demo.controller;

import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.SalesDetailRepository;
import com.example.demo.dto.SalesDto;
import com.example.demo.dto.SalesDetailDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalesController {

    private final SalesRepository repo;

    public SalesController(SalesRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/sales")
    public String list(Model model) {
        model.addAttribute("sales", repo.findAll());
        return "sales";
    }
    
    @GetMapping("/api/sales/{id}")
    public SalesDto getSales(@PathVariable Long id){
        Sales sales = repo.findById(id).orElseThrow();
    
        List<SalesDetailDto> details = sales.getDetails().stream()
            .map(d -> new SalesDetailDto(
                d.getItem().getName(),
                d.getQuantity()
            ))
            .toList();
    
        return new SalesDto(
            sales.getId(),
            sales.getSalesPerson(),
            sales.getTotalPrice(),
            details
        );
    }
}