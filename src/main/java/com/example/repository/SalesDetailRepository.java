package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.SalesDetail;
import com.example.entity.SalesDetailId;

public interface SalesDetailRepository extends JpaRepository<SalesDetail, SalesDetailId> {
}