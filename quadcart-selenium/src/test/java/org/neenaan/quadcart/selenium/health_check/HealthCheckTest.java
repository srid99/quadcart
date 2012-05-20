package org.neenaan.quadcart.selenium.health_check;

import org.junit.Test;
import org.neenaan.quadcart.selenium.conf.SeleniumTest;
import org.neenaan.quadcart.selenium.conf.SeleniumTestCase;

public class HealthCheckTest extends SeleniumTestCase {

    @Test
    @SeleniumTest( "Health check for quadcart application" )
    public void testApplicationLoaded() {
        open( "/" );
        assertContent( "Hello World!" );
    }

}
