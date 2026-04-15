package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.entity.Item;
import com.example.repository.ItemRepository;

@Service
public class ItemService {

 private final ItemRepository repo;

 public ItemService(ItemRepository repo){
  this.repo = repo;
 }

 public List<Item> findAll(){
  return repo.findAll();
 }

 public Item findById(Long id){
  return repo.findById(id).orElse(null);
 }

 public void save(Item item){
  repo.save(item);
 }

 public void delete(Long id){
  repo.deleteById(id);
 }
}