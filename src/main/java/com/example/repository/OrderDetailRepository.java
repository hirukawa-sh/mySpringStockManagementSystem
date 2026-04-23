package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}