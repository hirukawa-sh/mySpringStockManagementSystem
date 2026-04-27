package com.example.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Sales;
import java.util.*;

public interface SalesRepository extends JpaRepository<Sales, Long> {
  @Query("""
  SELECT s FROM Sales s
  LEFT JOIN FETCH s.details d
  LEFT JOIN FETCH d.item
  WHERE s.id = :id
  """)
  Optional<Sales> findWithDetails(@Param("id") Long id);
}