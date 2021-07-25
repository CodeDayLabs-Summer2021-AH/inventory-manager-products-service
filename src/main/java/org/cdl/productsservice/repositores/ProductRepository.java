package org.cdl.productsservice.repositores;

import org.cdl.productsservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Location, Long> {

}