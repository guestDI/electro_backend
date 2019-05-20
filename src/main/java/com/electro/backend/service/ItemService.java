package com.electro.backend.service;

import com.electro.backend.model.Item;
import com.electro.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Iterable<Item> getAll(){
        return itemRepository.findAll();


    }
}
