package com.javatechie.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;
    private String itemDescription;
    private String isVeg;
    private Number price;
    private Integer restaurantId;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
