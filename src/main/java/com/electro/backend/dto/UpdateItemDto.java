package com.electro.backend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateItemDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
