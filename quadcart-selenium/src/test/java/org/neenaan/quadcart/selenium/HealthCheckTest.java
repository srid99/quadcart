package org.neenaan.quadcart.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HealthCheckTest extends SeleniumTestCase {

    @Test
    @SeleniumTest( "Health check for quadcart application" )
    public void testApplicationLoaded() throws Exception{
        selenium().open( "/" );
        assertTrue( "Content \"Hello world\" not found", selenium().getBodyText().indexOf( "Hello World!" ) != -1 );
    }

}
