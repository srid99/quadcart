package org.neenaan.quadcart.selenium.conf;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;

import com.thoughtworks.selenium.Selenium;

public class SeleniumTestCase {

    @Rule
    public final SeleniumDriver driver = new SeleniumDriver();

    public void open( final String url ){
        selenium().open( url );
    }

    public void assertContent( final String content ){
        assertTrue( "Content \"" + content + "\" not found", contentPresent( content ) );
    }

    private Selenium selenium(){
        return driver.getSelenium();
    }

    private boolean contentPresent( final String content ){
        return selenium().getBodyText().indexOf( content ) != -1;
    }
}
