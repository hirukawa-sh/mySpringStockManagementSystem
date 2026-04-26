package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.OrderDetail;
import com.example.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}