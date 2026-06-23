package com.example.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class OrderDetail {

 @EmbeddedId
 private OrderDetailId id;

 @ManyToOne
 @MapsId("orderId")
 @JoinColumn(name = "order_id")
 private Order order;

 @ManyToOne
 @MapsId("itemId")
 @JoinColumn(name = "item_id")
 private Item item;

 private Integer quantity;
}