package com.example.demo.dto;

import com.example.demo.dto.SalesDetailDto;
import java.time.LocalDateTime;
import java.util.List;

public record SalesDto(
    Long id,
    String salesPerson,
    Integer totalPrice,
    LocalDateTime salesDate,
    List<SalesDetailDto> details
){}