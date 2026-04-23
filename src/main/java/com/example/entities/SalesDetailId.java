package com.example.demo.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
public class SalesDetailId implements Serializable {
 private Long salesId;
 private Long itemId;
}