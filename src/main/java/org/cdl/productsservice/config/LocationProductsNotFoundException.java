package org.cdl.productsservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationProductsNotFoundException extends RuntimeException {
    public LocationProductsNotFoundException(Long id) {
        super(String.format("Location with id '%d' not found!", id));
    }
}
