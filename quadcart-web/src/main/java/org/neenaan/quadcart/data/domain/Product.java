package org.neenaan.quadcart.data.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @Column( name = "product_id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long productId;
    @ManyToOne
    @JoinColumn( nullable = true, name = "manufacturer_id" )
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer( Manufacturer manufacturer ){
        this.manufacturer = manufacturer;
    }

    private BigDecimal price;

    public Long getProductId(){
        return productId;
    }

    public void setProductId( Long productId ){
        this.productId = productId;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice( BigDecimal price ){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product{ id: " + productId + ", manufacturer: " + manufacturer + ", price: " + price + "}";
    }
}
