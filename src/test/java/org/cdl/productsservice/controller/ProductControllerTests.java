package org.cdl.productsservice.controller;

import java.util.Collections;
import java.util.Date;

import org.cdl.productsservice.config.LocationProductsNotFoundException;
import org.cdl.productsservice.model.Location;
import org.cdl.productsservice.model.Product;
import org.cdl.productsservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    //getLocationProductsById
    @Test
    public void testGetLocationProductsById_successScenario() throws Exception {
        
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
        Mockito.when(productService.getLocationProductsById(1L)).thenReturn(mockLocation);
        
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/v1/product?id=1"))
            .andExpect(status().isOk());
    }

    //getLocationProductsById - LocationProductsNotFound
    @Test
    public void testGetLocationProductsById_LocationProductsNotFound() throws Exception {

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
        Mockito.when(productService.getLocationProductsById(1L)).thenThrow(new LocationProductsNotFoundException(1L));
        
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/v1/product?id=1"))
            .andExpect(content().string("Location with id '1' not found!"))
            .andExpect(status().isNotFound());
    }
}
