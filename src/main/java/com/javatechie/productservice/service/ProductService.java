package com.javatechie.productservice.service;

import com.javatechie.productservice.dto.ProductRequest;
import com.javatechie.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse saveProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
