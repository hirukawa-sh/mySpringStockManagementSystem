package com.example.dto;

public record OrderRequestDto(
    Long itemId,
    Integer quantity
){}