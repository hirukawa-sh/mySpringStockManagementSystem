package com.example.dto;

public record ItemStockDto(
    Long id,
    String name,
    Integer purchasePrice,
    Integer quantity
){}