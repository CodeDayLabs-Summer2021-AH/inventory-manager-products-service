package org.cdl.productsservice.controller;

import org.cdl.productsservice.model.Location;
import org.cdl.productsservice.model.Product;
import org.cdl.productsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.annotations.ApiOperation;

@RestController
@RestControllerAdvice
public class ProductController {
    
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Get all products from the database.")
    @GetMapping("/api/v1/product/{id}")
    public Location getProductsByLocId(@PathVariable Long id) {
        return productService.getProductsByLocId(id);
    }
}