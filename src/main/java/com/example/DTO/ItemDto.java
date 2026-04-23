package com.example.demo.dto;

public record ItemDto(
    Long id,
    String name,
    String supplier ,
    Integer purchasePrice,
    Integer salesPrice
){}