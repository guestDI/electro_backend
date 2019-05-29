package com.electro.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private String itemPhoto;
    private int quantity;
    private boolean availability;
    private boolean active;
}
