package com.example.dto;

public record ServiceResult<T>(
    boolean success,
    T data,
    String message
) {}