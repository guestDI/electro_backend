package com.electro.backend.service;

import com.electro.backend.converter.ItemConverter;
import com.electro.backend.dto.ItemDto;
import com.electro.backend.dto.UpdateItemDto;
import com.electro.backend.model.Item;
import com.electro.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

    public Iterable<Item> getAll(){
        return itemRepository.findAllByActiveTrue();
    }

    public List<ItemDto> findAll(Long categoryId) {
        return itemRepository.findByCategoryIdAndActiveTrue(categoryId)
                .stream()
                .map(itemConverter::convert)
                .collect(Collectors.toList());
    }

    public Integer setItemsAsInactive(Long id){
        return itemRepository.deleteItemById(id);
    }

    public void updateItem(UpdateItemDto updateItemDto){
        itemRepository.update(updateItemDto);
    }

    public Integer updateItemStatus(Long id, boolean status){
        return itemRepository.updateItemStatus(id, status);
    }
}
