package com.javatechie.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private String itemName;
    private String itemDescription;
    private String isVeg;
    private Number price;
    private Integer restaurantId;
    private Integer quantity;
}
