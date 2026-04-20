package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "商品名は必須です")
    @Size(max = 50, message = "50文字以内で入力してください")
    private String name;
    
    @NotBlank(message = "仕入先は必須です")
    private String supplier;
    
    @NotNull(message = "価格は必須です")
    @Min(value = 0, message = "0以上で入力してください")
    private Integer price;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }
}