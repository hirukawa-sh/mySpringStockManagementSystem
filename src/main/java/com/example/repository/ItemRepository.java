package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Item;
import com.example.dto.ItemStockDto;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("""
    SELECT new com.example.dto.ItemStockDto(
        i.id, i.name, i.purchasePrice, COALESCE(s.quantity, 0)
    )
    FROM Item i
    LEFT JOIN Stock s ON i.id = s.itemId
    """)
    List<ItemStockDto> findAllWithStock();
}