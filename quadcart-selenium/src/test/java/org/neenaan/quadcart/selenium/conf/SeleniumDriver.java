package org.neenaan.quadcart.selenium.conf;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.thoughtworks.selenium.Selenium;

public final class SeleniumDriver extends TestWatcher {

    private static final Class<SeleniumTest> SELENIUM_ANNOTATION_CLASS = SeleniumTest.class;

    private Selenium selenium;

    @Override
    protected void starting( final Description description ) {
        final SeleniumTest seleniumTest = description.getAnnotation( SELENIUM_ANNOTATION_CLASS );
        if ( seleniumTest != null ) {
            selenium = new SeleniumConfiguration( seleniumTest.value() ).getSelenium();
            selenium.start();
        }
    }

    @Override
    protected void finished( final Description description ) {
        if ( selenium != null ) {
            selenium.stop();
            selenium = null;
        }
    }

    public Selenium getSelenium() {
        if ( selenium == null ) {
            throw new IllegalStateException( "No @" + SELENIUM_ANNOTATION_CLASS.getSimpleName() + " configured for this test case." );
        }
        return selenium;
    }

}
