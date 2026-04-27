package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Sales;
import com.example.entity.SalesDetail;
import com.example.entity.SalesDetailId;

public interface SalesDetailRepository extends JpaRepository<SalesDetail, SalesDetailId> {
  @Query("""
  SELECT s FROM Sales s
  LEFT JOIN FETCH s.details d
  LEFT JOIN FETCH d.item
  WHERE s.id = :id
  """)
  Optional<Sales> findWithDetails(@Param("id") Long id);
}