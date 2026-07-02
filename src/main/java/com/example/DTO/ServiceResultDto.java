package com.example.dto;

public record ServiceResultDto<T>(
    boolean success,
    T data,
    String message
) {}