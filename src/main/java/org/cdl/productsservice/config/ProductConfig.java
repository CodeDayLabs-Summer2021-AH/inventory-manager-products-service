package org.cdl.productsservice.config;

import java.util.Date;
import java.util.List;

import org.cdl.productsservice.model.Location;
import org.cdl.productsservice.model.Product;
import org.cdl.productsservice.repositores.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product a = new Product("TRE-MED-GRE-LEA", "Tree Solhold", "Row 1", "Section 5", 50, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product b = new Product("QTI-BIG-Q-TIP", "Q-Tip 2.0", "Row 2", "Section 10", 1000.5, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product c = new Product("VOL-VOL-QUA-FAX", "Voltquadfax", "Row 2", "Section 3", 6, new Date(), "https://i.imgur.com/9SzGfiH.png");

            Location location = new Location(List.of(a, b, c));

            productRepository.save(location);
        };
    }
}