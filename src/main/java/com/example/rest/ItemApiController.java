package com.example.rest;

import com.example.entity.Item;
import com.example.repository.ItemRepository;
import com.example.dto.ItemDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemApiController {

    private final ItemRepository repo;

    public ItemApiController(ItemRepository repo){
        this.repo = repo;
    }

    @GetMapping("/items")
    public List<ItemDto> getItemList(){
        return repo.findAll()
            .stream()
            .map(d -> new ItemDto(
                d.getId(),
                d.getName(),
                d.getSupplier(),
                d.getPurchasePrice(),
                d.getSalesPrice()
            ))
            .toList();
    }
}
