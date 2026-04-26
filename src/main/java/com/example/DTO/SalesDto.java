package com.example.dto;

import com.example.dto.SalesDetailDto;
import java.time.LocalDateTime;
import java.util.List;

public record SalesDto(
    Long id,
    String salesPerson,
    Integer totalPrice,
    LocalDateTime salesDate
){}