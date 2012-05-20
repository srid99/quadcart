package org.neenaan.quadcart.selenium.conf;

import java.io.IOException;
import java.util.Properties;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumConfiguration {

    private final static String[] BROWSER_COMMAND_KEYS = { "username" , "access-key" , "os" , "browser" , "browser-version" };

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

    public Selenium getSelenium(){
        return new DefaultSelenium( host , port , browserCommand , url );
    }

    private Properties loadSeleniumProperties(){
        final Properties props = new Properties();
        try {
            props.load( SeleniumDriver.class.getClassLoader().getResourceAsStream( "selenium.properties" ) );
        }
        catch ( final IOException e ) {
            e.printStackTrace();
        }
        return props;
    }

    private String getBrowserCommand( final String testCaseName , final Properties props ){
        final StringBuilder command = new StringBuilder( "{" );
        for ( final String key : BROWSER_COMMAND_KEYS ) {
            command.append( keyValuePair( props, key ) ).append( "," );
        }
        return command.append( quotes( "name" ) ).append( ":" ).append( quotes( testCaseName ) ).append( "}" ).toString();
    }

    private String keyValuePair( final Properties props , final String key ){
        return quotes( key ) + ":" + quotes( props.getProperty( key ) );
    }

    private String quotes( final String value ){
        return "\"" + value + "\"";
    }

}
