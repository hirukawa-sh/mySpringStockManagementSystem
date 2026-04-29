package com.example.entity;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "item_id")
    private Item item;
    
    private Integer quantity;
}