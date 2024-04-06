package com.javatechie.productservice.service;

import com.javatechie.productservice.dto.ProductRequest;
import com.javatechie.productservice.dto.ProductResponse;
import com.javatechie.productservice.entity.Product;
import com.javatechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .itemName(productRequest.getItemName())
                .itemDescription(productRequest.getItemDescription())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .isVeg(productRequest.getIsVeg())
                .restaurantId(productRequest.getRestaurantId())
                .build();

        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse = ProductResponse.builder()
                .id(savedProduct.getId())
                .itemName(savedProduct.getItemName())
                .itemDescription(savedProduct.getItemDescription())
                .price(savedProduct.getPrice())
                .quantity(savedProduct.getQuantity())
                .isVeg(savedProduct.getIsVeg())
                .restaurantId(savedProduct.getRestaurantId())
                .build();

        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<ProductResponse> allProducts = productRepository.findAll().stream().map(product -> ProductResponse.builder()
                .id(product.getId())
                .itemName(product.getItemName())
                .itemDescription(product.getItemDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .isVeg(product.getIsVeg())
                .restaurantId(product.getRestaurantId())
                .build()).toList();
        return allProducts;
    }
}
