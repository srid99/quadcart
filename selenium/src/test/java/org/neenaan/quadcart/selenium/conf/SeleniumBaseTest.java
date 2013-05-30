package org.neenaan.quadcart.selenium.conf;

import static org.neenaan.quadcart.selenium.conf.SeleniumService.SELENIUM_SERVICE;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Selenium;

public abstract class SeleniumBaseTest {

    @BeforeClass
    public static void setup() {
        SELENIUM_SERVICE.start();
    }

    public Selenium selenium() {
        return SELENIUM_SERVICE.getSelenium();
    }

    public WebDriver driver() {
        return SELENIUM_SERVICE.getWebDriver();
    }

    @AfterClass
    public static void teardown() {
        SELENIUM_SERVICE.stop();
    }
}
