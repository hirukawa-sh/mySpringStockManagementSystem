package com.example.dto;

import com.example.dto.OrderDetailDto;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
    Long id,
    String orderPerson,
    Integer totalPrice,
    LocalDateTime orderDate,
    List<OrderDetailDto> details
){}