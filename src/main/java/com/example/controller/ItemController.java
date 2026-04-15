package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

 private final ItemService service;

 public ItemController(ItemService service){
  this.service = service;
 }

 // ログイン
 @GetMapping("/login")
 public String login(Model model){
    return "item/login";
 }

 // 一覧
 @GetMapping
 public String list(Model model){
  model.addAttribute("items", service.findAll());
  return "item/list";
 }

 // 登録画面
 @GetMapping("/new")
 public String createForm(Model model){
  model.addAttribute("item", new Item());
  return "item/form";
 }

 // 登録処理
 @PostMapping("/save")
 public String save(Item item){
  service.save(item);
  return "redirect:/item";
 }

 // 編集画面
 @GetMapping("/edit/{id}")
 public String edit(@PathVariable Long id, Model model){
  model.addAttribute("item", service.findById(id));
  return "item/form";
 }

 // 削除
 @GetMapping("/delete/{id}")
 public String delete(@PathVariable Long id){
  service.delete(id);
  return "redirect:/item";
 }
}