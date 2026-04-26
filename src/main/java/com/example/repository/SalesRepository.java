package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}