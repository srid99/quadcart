package org.neenaan.quadcart.web.controller.sales;

import org.neenaan.quadcart.data.jpa.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {

    private static final Logger LOG = LoggerFactory.getLogger( SalesController.class );

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping( value = "/sales/new", method = RequestMethod.GET )
    public void listProducts( final Model model ) {
        LOG.debug( "List the product details" );
        model.addAttribute( "products", productRepository.findAll() );
    }

}
