package org.neenaan.quadcart.selenium.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.base.Preconditions;
import com.thoughtworks.selenium.Selenium;

public class SeleniumService {

    public static final SeleniumService SELENIUM_SERVICE = new SeleniumService();

    private WebDriver webDriver;
    private Selenium selenium;

    private String url;
    private String timeout;

    private SeleniumService() {
    }

    public void start() {
        if ( selenium == null ) {
            final Properties properties = loadSeleniumConfigProperties();

            url = properties.getProperty( "application.url" );
            timeout = properties.getProperty( "selenium.actions.to.complete.timeout" );

            webDriver = new FirefoxDriver();
            selenium = new WebDriverBackedSelenium( webDriver , url );

            selenium.setTimeout( timeout );
            selenium.open( url );
        }
    }

    private Properties loadSeleniumConfigProperties() {
        final Properties properties = new Properties();

        try {
            final InputStream in = this.getClass().getClassLoader().getResourceAsStream( "selenium_dev.properties" );
            properties.load( in );
        }
        catch ( final IOException e ) {
            throw new IllegalStateException( "Not able to load the resource" , e );
        }

        return properties;
    }

    public Selenium getSelenium() {
        Preconditions.checkNotNull( selenium, "Make sure selenium service is started" );

        return selenium;
    }

    public WebDriver getWebDriver() {
        Preconditions.checkNotNull( webDriver, "Make sure selenium service is started" );

        return webDriver;
    }

    public void stop() {
        Preconditions.checkNotNull( selenium, "No selenium service is running to stop" );

        selenium.close();
        selenium = null;
        webDriver = null;
    }
}
