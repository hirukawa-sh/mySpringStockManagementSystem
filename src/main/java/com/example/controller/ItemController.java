package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.dto.ItemDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    // 一覧
    @GetMapping("/items")
    public String list(Model model) {
        model.addAttribute("items", repo.findAll());
        return "items";
    }

    // 新規
    @GetMapping("/items/new")
    public String newForm(Model model){
        model.addAttribute("item", new Item());
        return "edititem";
    }

    // 編集
    @GetMapping("/items/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("item", repo.findById(id).orElse(new Item()));
        return "edititem";
    }

    // 更新
    @PostMapping("/items")
    public String save(
        @Valid Item item,
        BindingResult result,
        Model model
    ){
        // エラーがある場合
        if(result.hasErrors()){
            return "edititem"; // 入力画面に戻る
        }
        repo.save(item);
        return "redirect:/items";
    }
    
    // 削除
    @PostMapping("/items/delete/{id}")
    public String delete(@PathVariable Long id){
        repo.deleteById(id);
        return "redirect:/items";
    }
    
    // 取得API
    @GetMapping("/api/items")
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