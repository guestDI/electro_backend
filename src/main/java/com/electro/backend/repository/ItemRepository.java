package com.electro.backend.repository;

import com.electro.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryId(Long categoryId);

    @Modifying(clearAutomatically = true)
    @Query("Update Item i SET i.availability = :status WHERE i.id = :id")
    Integer updateItemStatus(@Param("id") Long itemId, @Param("status") boolean status);
}
