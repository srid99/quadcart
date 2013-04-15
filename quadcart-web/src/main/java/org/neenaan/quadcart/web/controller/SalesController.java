package org.neenaan.quadcart.web.controller;

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

    @RequestMapping( value = "/sales/searchproduct", method = RequestMethod.GET )
    public void searchProducts( final Model model , @RequestParam( "q" ) final String searchQuery ) {
        LOG.trace( "Search products for given query string [ {} ]", searchQuery );

        final List<Product> matchedProducts = productBO.searchProducts( searchQuery );
        model.addAttribute( "searchResult", matchedProducts );

        LOG.debug( "Total of {} products found for the given query", matchedProducts.size() );
    }
}
