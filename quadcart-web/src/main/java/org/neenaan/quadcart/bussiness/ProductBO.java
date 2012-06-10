package org.neenaan.quadcart.bussiness;

import java.util.List;

import org.neenaan.quadcart.data.domain.Product;

public interface ProductBO {

    List<Product> getProducts();
    List<Product> searchProducts(String queryText);

}
