package com.example.controller;

import com.example.service.OrderService;
import com.example.dto.OrderRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String order(@RequestParam Map<String, String> params){

        List<OrderRequestDto> requests = params.entrySet().stream()
            .filter(e -> e.getKey().startsWith("order_"))
            .map(e -> {
                Long itemId = Long.valueOf(e.getKey().replace("order_", ""));
                Integer qty = Integer.valueOf(e.getValue());
                return new OrderRequestDto(itemId, qty);
            })
            .filter(r -> r.quantity() > 0)
            .toList();

        orderService.createOrder(requests);

        return "redirect:/stock";
    }
}