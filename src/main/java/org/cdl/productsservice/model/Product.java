package org.cdl.productsservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(double quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public Date getDate_received() {
        return date_received;
    }

    public void setDate_received(Date date_received) {
        this.date_received = date_received;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
