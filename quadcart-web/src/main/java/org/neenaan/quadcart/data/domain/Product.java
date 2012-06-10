package org.neenaan.quadcart.data.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Product.searchByDescription", query = "from Product p where p.description LIKE ?1" )
public class Product {

    @Id
    @Column( name = "product_id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long productId;
    
    @Column( name = "name" )
    private String name;
    
    @Column( name = "description" )
    private String description;


    @ManyToOne
    @JoinColumn( nullable = true, name = "manufacturer_id" )
    private Manufacturer manufacturer;

    @Column( name = "price" )
    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId( final Long productId ) {
        this.productId = productId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer( final Manufacturer manufacturer ) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice( final BigDecimal price ) {
        this.price = price;
    }
    
    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{ id: " + productId + ", manufacturer: " + manufacturer + ", price: " + price + "}";
    }
}
