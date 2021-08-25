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

            Product d = new Product("RGB-XYZ-WES", "Water Bottle", "Row 8", "Section 1", 12, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product e = new Product("FLO-BIG-LIGHT", "Floor Lamp", "Row 3", "Section 12", 7, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product f = new Product("BLK-INK-CAR", "Ink Cartridge", "Row 2", "Section 5", 68.4, new Date(), "https://i.imgur.com/9SzGfiH.png");

            Product g = new Product("FLIP-CEL-PHO", "Cell Phone", "Row 1", "Section 2", 32.12, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product h = new Product("LIT-WAIT-OIL", "Motor Oil", "Row 17", "Section 5", 867, new Date(), "https://i.imgur.com/9SzGfiH.png");
            Product i = new Product("VAC-CLE-NEW", "Vacuum Cleaner", "Row 42", "Section 11", 3, new Date(), "https://i.imgur.com/9SzGfiH.png");

            Location location1 = new Location(List.of(a, b, c));
            Location location2 = new Location(List.of(d, e, f));
            Location location3 = new Location(List.of(g, h, i));

            productRepository.save(location1);
            productRepository.save(location2);
            productRepository.save(location3);
        };
    }
}