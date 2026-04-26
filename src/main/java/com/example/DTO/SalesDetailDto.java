package com.example.dto;

public record SalesDetailDto(
    long id,
    String itemName,
    Integer salesPrice,
    Integer quantity
){}