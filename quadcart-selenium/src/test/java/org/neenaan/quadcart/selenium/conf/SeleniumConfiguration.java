package org.neenaan.quadcart.selenium.conf;

import java.io.IOException;
import java.util.Properties;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumConfiguration {

    private final static String[] BROWSER_COMMAND_KEYS = { "username" , "os" , "browser" , "browser-version" };

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
            command.append( jsonPair( key, props.getProperty( key ) ) ).append( "," );
        }
        command.append( jsonPair( "access-key", getAccessKey() ) ).append( "," );
        return command.append( jsonPair( "name", testCaseName ) ).append( "}" ).toString();
    }

    private String getAccessKey(){
        final String key = System.getProperty( "access-key" );
        return key == null ? System.getenv( "access-key" ) : key;
    }

    private String jsonPair( final String key , final String value ){
        return quotes( key ) + ":" + quotes( value );
    }

    private String quotes( final String value ){
        return "\"" + value + "\"";
    }

}
