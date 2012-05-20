package org.neenaan.quadcart.web.controller.sales;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {
    
    @RequestMapping(value = "/sales/new", method = RequestMethod.GET)
    public void loadNewSales() {
       
    }

}
