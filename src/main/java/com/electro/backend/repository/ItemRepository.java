package com.electro.backend.repository;

import com.electro.backend.dto.UpdateItemDto;
import com.electro.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryIdAndActiveTrue (Long categoryId);

    List<Item> findAllByActiveTrue();

    @Modifying(clearAutomatically = true)
    @Query("Update Item i SET i.availability = :status WHERE i.id = :id")
    Integer updateItemStatus(@Param("id") Long itemId, @Param("status") boolean status);

    @Modifying(clearAutomatically = true)
    @Query("Update Item i SET i.active = false WHERE i.id = :id")
    int deleteItemById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Item i SET i.name = :#{#dto.name}, i.description = :#{#dto.description}, i.price = :#{#dto.price} WHERE i.id = :#{#dto.id}")
    int update(@Param("dto") UpdateItemDto dto);

//    int deleteItemByIdEquals(@Param("id") Long id);
}
