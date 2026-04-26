package com.example.dto;

public record OrderDetailDto(
    long id,
    String itemName,
    Integer purchasePrice,
    Integer quantity
){}