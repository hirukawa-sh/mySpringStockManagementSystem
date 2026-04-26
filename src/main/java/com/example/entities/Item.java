package com.example.entity;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
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
    private Integer purchasePrice;
    
    @NotNull(message = "価格は必須です")
    @Min(value = 0, message = "0以上で入力してください")
    private Integer salesPrice;
}