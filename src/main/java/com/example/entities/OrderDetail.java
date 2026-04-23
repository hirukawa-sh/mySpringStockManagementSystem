package com.example.demo.entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@IdClass(OrderDetailId.class)
public class OrderDetail {

 @Id
 private Long orderId;

 @Id
 private Long itemId;

 @ManyToOne
 @JoinColumn(name = "order_id", insertable = false, updatable = false)
 private Order order;

 @ManyToOne
 @JoinColumn(name = "item_id", insertable = false, updatable = false)
 private Item item;

 private Integer quantity;
}