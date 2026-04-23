package com.example.demo.entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class SalesDetail {

 @EmbeddedId
 private SalesDetailId id;

 @ManyToOne
 @MapsId("salesId")
 @JoinColumn(name = "sales_id")
 private Sales sales;

 @ManyToOne
 @MapsId("itemId")
 @JoinColumn(name = "item_id")
 private Item item;

 private Integer quantity;
}