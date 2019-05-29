package com.electro.backend.controller;

import com.electro.backend.converter.ItemConverter;
import com.electro.backend.dto.ItemDto;
import com.electro.backend.model.Item;
import com.electro.backend.repository.ItemRepository;
import com.electro.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.google.common.collect.Lists;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

    @RequestMapping(value = "/getAllItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Item> findAll() {
        return itemService.getAll();
    }

    @RequestMapping(value = "/getItemsByCategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ItemDto> findItemsByCategory(@PathVariable("id") Long id) {
        return itemService.findAll(id);
    }
}
