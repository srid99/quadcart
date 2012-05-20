package org.neenaan.quadcart.selenium;

import org.junit.Rule;

import com.thoughtworks.selenium.Selenium;

public class SeleniumTestCase {

    @Rule
    public final SeleniumDriver driver = new SeleniumDriver();

    public Selenium selenium(){
        return driver.getSelenium();
    }
}
