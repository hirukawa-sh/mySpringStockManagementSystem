package com.example.demo.entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@IdClass(SalesDetailId.class)
public class SalesDetail {

 @Id
 private Long salesId;

 @Id
 private Long itemId;

 @ManyToOne
 @JoinColumn(name = "sales_id", insertable = false, updatable = false)
 private Sales sales;

 @ManyToOne
 @JoinColumn(name = "item_id", insertable = false, updatable = false)
 private Item item;

 private Integer quantity;
}