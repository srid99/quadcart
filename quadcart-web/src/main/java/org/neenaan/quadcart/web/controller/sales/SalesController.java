package org.neenaan.quadcart.web.controller.sales;

import org.neenaan.quadcart.bussiness.ProductBO;
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

    private final ProductBO productBO;

    @Autowired
    public SalesController(final ProductBO productBO) {
        this.productBO = productBO;
    }

    @RequestMapping( value = "/sales/new", method = RequestMethod.GET )
    public void listProducts( final Model model ) {
        LOG.trace( "List the product details" );
        model.addAttribute( "products", productBO.getProducts() );
    }

}
