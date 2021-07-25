package org.cdl.productsservice.service;

import org.cdl.productsservice.config.ProductNotFoundException;
import org.cdl.productsservice.model.Location;
import org.cdl.productsservice.repositores.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Location getProductsByLocId(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
