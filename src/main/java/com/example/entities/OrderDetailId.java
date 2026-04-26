package com.example.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
public class OrderDetailId implements Serializable {
 private Long orderId;
 private Long itemId;
}