package com.javatechie.productservice.controller;

import com.javatechie.productservice.dto.ProductRequest;
import com.javatechie.productservice.dto.ProductResponse;
import com.javatechie.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    Logger logger = Logger.getLogger(ProductController.class.getName());

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest) {
            ProductResponse productResponse = productService.saveProduct(productRequest);
        logger.info("Product saved successfully {}" + productResponse.getId());
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllProducts() {
        logger.info("Fetching all products");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
