package com.example.entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalPrice;
    private String salesPerson;
    private LocalDateTime salesDate;
    
    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private java.util.List<SalesDetail> details;
}