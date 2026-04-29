package com.example.service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.entity.*;
import com.example.repository.*;
import com.example.dto.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final ItemRepository itemRepo;
    private final StockRepository stockRepo;

    @Transactional
    public void createOrder(List<OrderRequestDto> requests){

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());

        List<OrderDetail> details = new ArrayList<>();

        for(OrderRequestDto req : requests){

            if(req.quantity() == null || req.quantity() <= 0){
                continue;
            }

            Item item = itemRepo.findById(req.itemId())
                    .orElseThrow();

            // ★ここが重要（複合キー生成）
            OrderDetailId id = new OrderDetailId();
            id.setOrderId(order.getId());
            id.setItemId(item.getId());

            OrderDetail d = new OrderDetail();
            d.setId(id);
            d.setOrder(order);
            d.setItem(item);
            d.setQuantity(req.quantity());

            details.add(d);

            // 在庫更新
            Stock stock = stockRepo.findById(item.getId())
                    .orElseGet(() -> {
                        Stock s = new Stock();
                        s.setItem(item);
                        s.setQuantity(0);
                        return s;
                    });

            stock.setQuantity(stock.getQuantity() + req.quantity());
            stockRepo.save(stock);
        }

        order.setDetails(details);
        orderRepo.save(order);
    }
}