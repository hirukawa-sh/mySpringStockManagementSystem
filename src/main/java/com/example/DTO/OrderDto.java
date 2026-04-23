package com.example.demo.dto;

import com.example.demo.dto.OrderDetailDto;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
    Long id,
    String orderPerson,
    Integer totalPrice,
    LocalDateTime orderDate,
    List<OrderDetailDto> details
){}