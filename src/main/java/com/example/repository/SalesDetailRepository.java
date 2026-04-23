package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SalesDetail;
import com.example.demo.entity.SalesDetailId;

public interface SalesDetailRepository extends JpaRepository<SalesDetail, SalesDetailId> {
}