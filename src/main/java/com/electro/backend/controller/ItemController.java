package com.electro.backend.controller;

import com.electro.backend.converter.ItemConverter;
import com.electro.backend.dto.ItemDto;
import com.electro.backend.dto.UpdateItemDto;
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

    @RequestMapping(value = "/updateItem", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UpdateItemDto updateItemDto) {
        itemService.updateItem(updateItemDto);
    }

    @RequestMapping(value = "/updateItemStatus/{id}/{status}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer updateItemStatus(@PathVariable("id") Long id, @PathVariable("status") boolean status) {
        return itemService.updateItemStatus(id, status);
    }

    @RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer deleteItemById(@PathVariable("id") Long id) {
        return itemService.setItemsAsInactive(id);
    }
}
