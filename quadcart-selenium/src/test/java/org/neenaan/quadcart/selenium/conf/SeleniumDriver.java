package org.neenaan.quadcart.selenium.conf;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.thoughtworks.selenium.Selenium;

public final class SeleniumDriver extends TestWatcher {

    private Selenium selenium;

    @Override
    protected void starting( final Description description ) {
        final SeleniumTest seleniumTest = description.getAnnotation( SeleniumTest.class );
        if ( seleniumTest != null ) {
            selenium = new SeleniumConfiguration( seleniumTest.value() ).getSelenium();
            selenium.start();
        }
    }

    @Override
    protected void finished( Description description ) {
        if ( selenium != null ) {
            selenium.stop();
            selenium = null;
        }
    }

    public Selenium getSelenium() {
        if ( selenium == null ) {
            throw new IllegalStateException( "No @" + SeleniumTest.class.getSimpleName() + " configured for this test case." );
        }
        return selenium;
    }

}
