package com.example.demo.dto;

import com.example.demo.dto.SalesDetailDto;
import java.time.LocalDateTime;

public record SalesDto(
    Long id,
    String salesPerson,
    Integer totalPrice,
    LocalDateTime salesDate,
    List<SalesDetailDto> details
){}