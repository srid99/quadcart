package org.neenaan.quadcart.data.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Manufacturer {

    @Id
    @Column( name = "manufacturer_id" )
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long manufacturerId;

    @Column( name = "name" )
    private String name;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId( final Long manufacturerId ) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName( final String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manufacturer{ id: " + manufacturerId + ", name: " + name + "}";
    }

}
