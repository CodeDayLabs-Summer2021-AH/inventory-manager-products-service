package org.cdl.productsservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;
    private String sku;
    private String name;
    private String row;
    private String section;
    private double quantity_on_hand;
    private Date date_received;
    private String image;

    public Product() {
        
    }

    public Product(String sku, String name, String row, String section, double quantity_on_hand, Date date_received, String image) { 
        this.sku = sku;
        this.name = name;
        this.row = row;
        this.section = section;
        this.quantity_on_hand = quantity_on_hand;
        this.date_received = date_received;
        this.image = image;
    }
}
