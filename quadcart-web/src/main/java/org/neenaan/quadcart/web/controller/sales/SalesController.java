package org.neenaan.quadcart.web.controller.sales;

import java.util.List;
import org.neenaan.quadcart.data.domain.Product;
import org.neenaan.quadcart.data.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {
    
    @Autowired
    ProductRepository productRepository;
    
    public void setProductRepository( ProductRepository productRepository ){
        this.productRepository = productRepository;
    }
    @RequestMapping(value = "/sales/new", method = RequestMethod.GET)
    
    public void loadNewSales(Model model) {
       List<Product> products= productRepository.findAll();
       model.addAttribute( "products", products );
    }

}
