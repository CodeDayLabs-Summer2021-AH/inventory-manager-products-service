package org.cdl.productsservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.Date;

import org.cdl.productsservice.config.LocationProductsNotFoundException;
import org.cdl.productsservice.model.Location;
import org.cdl.productsservice.model.Product;
import org.cdl.productsservice.repositores.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductServiceTest {
    
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    //getLocationProducts - success
    @Test
    public void testGetLocationProductsById_locationFound() {
        Product mockProducts = new Product();
        mockProducts.setId(2L);
        mockProducts.setName("Test Product");
        mockProducts.setSku("test-sku");
        mockProducts.setRow("Row 1");
        mockProducts.setSection("Section 1");
        mockProducts.setQuantityOnHand(5.0);
        mockProducts.setDateReceived(new Date());
        mockProducts.setImage("test.png");
        
        Location mockLocation = new Location();
        mockLocation.setId(1L);
        mockLocation.setProducts(Collections.singletonList(mockProducts));     
       
        Mockito.when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockLocation));

        Location actualResponse = productService.getLocationProductsById(1L);
        
        assertEquals(mockLocation, actualResponse);
    }

    //getLocationProducts - throwError
    @Test
    public void testGetLocationProductsById_locationNotFound() {    
        Mockito.when(productRepository.findById(1L)).thenThrow(new LocationProductsNotFoundException(1L));

        Exception execption = assertThrows(
            LocationProductsNotFoundException.class,
                () -> productService.getLocationProductsById(1L)
        );
        
        assertEquals("Location with id '1' not found!", execption.getMessage());

    }    
}
