package org.neenaan.quadcart.selenium.health_check;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.neenaan.quadcart.selenium.conf.SeleniumBaseTest;

import com.thoughtworks.selenium.Selenium;

public class HealthCheckTest extends SeleniumBaseTest {

    @Test
    public void testApplicationStartedWithoutError() {
        final Selenium selenium = selenium();

        assertThat( selenium.getTitle(), is( "QuadCart" ) );
        assertTrue( selenium.isElementPresent( "searchbox" ) );
    }
}
