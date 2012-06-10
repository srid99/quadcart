package org.neenaan.quadcart.data.jpa.repository;

import java.util.List;

import org.neenaan.quadcart.data.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> searchByDescription(String description);
}
