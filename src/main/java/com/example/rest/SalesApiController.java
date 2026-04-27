package com.example.rest;

import com.example.entity.Sales;
import com.example.entity.SalesDetailId;
import com.example.repository.SalesRepository;
import com.example.dto.SalesDto;
import com.example.dto.SalesDetailDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesApiController {

    private final SalesRepository repo;

    public SalesApiController(SalesRepository repo){
        this.repo = repo;
    }

    @GetMapping("/sales")
    public List<SalesDto> getSalesList(){
        return repo.findAll()
            .stream()
            .map(d -> new SalesDto(
                d.getId(),
                d.getSalesPerson(),
                d.getTotalPrice(),
                d.getSalesDate()
            ))
            .toList();
    }

    @GetMapping("/sales/{id}")
    public SalesDto getSalesById(@PathVariable Long id) {
        Sales sales = repo.findById(id).orElseThrow();
        return new SalesDto(
            sales.getId(),
            sales.getSalesPerson(),
            sales.getTotalPrice(),
            sales.getSalesDate()
        );
    }
    
    @GetMapping("/sales/{id}/details")
    public List<SalesDetailDto> getDetails(@PathVariable Long id){
        Sales sales = repo.findWithDetails(id).orElseThrow();
        return sales.getDetails()
            .stream()
            .map(d -> new SalesDetailDto(
                d.getItem().getId(),
                d.getItem().getName(),
                d.getItem().getSalesPrice(),
                d.getQuantity()
            ))
            .toList();
    }

/*
    @GetMapping("/sales/{id}/details")
    public List<SalesDetailDto> getSalesDetailsBySalesId(@PathVariable Long id) {
        Sales sales = repo.findById(id).orElseThrow();
        return sales.getDetails()
            .stream()
            .map(d -> new SalesDetailDto(
                d.getItem().getId(),
                d.getItem().getName(),
                d.getItem().getSalesPrice(),
                d.getQuantity()
            ))
            .toList();
    }
    */
}