package org.neenaan.quadcart.web.controller.sales;

import java.util.List;
import org.neenaan.quadcart.bussiness.ProductBO;
import org.neenaan.quadcart.data.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        LOG.trace( "List the product In DB" +productBO.getProducts() );
    }
    
    @RequestMapping( value = "/sales/searchproduct", method = RequestMethod.GET )
    public void searchProducts( final Model model ,@RequestParam String q) {
        LOG.debug( "Search Product for Query String:"+q );
        List<Product> matchedProducts=productBO.searchProducts( "%"+q+"%" );
        LOG.debug( "List the product details Searched"+matchedProducts );
        model.addAttribute( "searchResult", matchedProducts );
    }

}
