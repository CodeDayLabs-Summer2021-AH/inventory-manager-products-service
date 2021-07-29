package org.cdl.productsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration

public class Swagger {                                    
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info().title("Inventory Manager product service API")
                .description("Inventory Manager Product Service Documentation").version("v0.0.1")
                .license(new License().name("GPL v3.0").url(
                        "https://github.com/CodeDayLabs-Summer2021-AH/inventory-manager-products-service/blob/master/LICENSE")));
    }
}
