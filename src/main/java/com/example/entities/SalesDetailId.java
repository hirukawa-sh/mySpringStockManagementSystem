package com.example.demo.entity;

import java.io.Serializable;
import lombok.*;

@Data
public class SalesDetailId implements Serializable {
 private Long salesId;
 private Long itemId;
}