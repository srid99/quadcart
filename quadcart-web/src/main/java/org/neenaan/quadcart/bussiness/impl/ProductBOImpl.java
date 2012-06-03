package org.neenaan.quadcart.bussiness.impl;

import java.util.List;

import org.neenaan.quadcart.bussiness.ProductBO;
import org.neenaan.quadcart.data.domain.Product;
import org.neenaan.quadcart.data.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductBOImpl implements ProductBO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductBOImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional( readOnly = true )
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
