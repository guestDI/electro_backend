package com.electro.backend.converter;

import com.electro.backend.dto.ItemDto;
import com.electro.backend.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {
    public ItemDto convert(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getItemPhoto(), item.getQuantity(),
                item.isAvailability(), item.isActive());
    }
}
