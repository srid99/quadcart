package org.neenaan.quadcart.selenium.conf;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumConfiguration {

    private final static String[] BROWSER_COMMAND_KEYS = { "username" , "os" , "browser" , "browser-version" , "access-key" };

    private final String host;
    private final int port;
    private final String browserCommand;
    private final String url;

    public SeleniumConfiguration(final String testCaseName) {
        final Properties props = loadSeleniumProperties();
        host = props.getProperty( "server.host" );
        port = Integer.parseInt( props.getProperty( "server.port" ) );
        browserCommand = getBrowserCommand( testCaseName, props );
        url = props.getProperty( "application.url" );
    }

    public Selenium getSelenium() {
        return new DefaultSelenium( host , port , browserCommand , url );
    }

    private Properties loadSeleniumProperties() {
        final Properties props = new Properties();
        try {
            props.load( SeleniumDriver.class.getClassLoader().getResourceAsStream( "selenium.properties" ) );
            props.putAll( System.getProperties() );
        }
        catch ( final IOException e ) {
            // do nothing
        }
        return props;
    }

    private String getBrowserCommand( final String testCaseName , final Properties props ) {
        final JSONObject json = new JSONObject();
        try {
            for ( final String key : BROWSER_COMMAND_KEYS ) {
                json.put( key, props.getProperty( key ) );
            }
            json.put( "name", testCaseName );
        }
        catch ( final JSONException e ) {
            // do nothing
        }
        return json.toString();
    }

}
