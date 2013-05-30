package org.neenaan.quadcart.selenium.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class SeleniumService {

    public static final SeleniumService SELENIUM_SERVICE = new SeleniumService();

    private Selenium selenium;
    private String url;

    private SeleniumService() {
    }

    public void start() {
        if ( selenium == null ) {
            final Properties properties = loadConfigProperties();
            url = properties.getProperty( "application.url" );

            final WebDriver driver = new FirefoxDriver();
            selenium = new WebDriverBackedSelenium( driver , url );
            selenium.open( url );
        }
    }

    private Properties loadConfigProperties() {
        final Properties properties = new Properties();

        try {
            final InputStream in = this.getClass().getClassLoader().getResourceAsStream( "selenium_dev.properties" );
            properties.load( in );
        }
        catch ( final IOException e ) {
            throw new IllegalStateException( "Resource not able to load" , e );
        }

        return properties;
    }

    public Selenium getSeleniumWithFirefoxDriver() {
        if ( selenium == null ) {
            throw new IllegalStateException( "Make sure service setup is done" );
        }

        return selenium;
    }

    public void stop() {
        selenium.close();
        selenium = null;
    }
}
