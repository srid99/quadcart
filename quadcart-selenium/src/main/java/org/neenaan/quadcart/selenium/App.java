package org.neenaan.quadcart.selenium;

import junit.framework.TestCase;

import com.thoughtworks.selenium.DefaultSelenium;

/**
 * Hello world!
 * 
 */
public class App extends TestCase {
	private DefaultSelenium selenium;

	public void setUp() throws Exception {
		DefaultSelenium selenium = new DefaultSelenium(
				"ondemand.saucelabs.com",
				80,
				"{\"username\": \"neenaan\","
						+ "\"access-key\": \"0fbd45d1-1429-45bf-af60-34c12eff93de\","
						+ "\"os\": \"Windows 2003\","
						+ "\"browser\": \"firefox\","
						+ "\"browser-version\": \"7\","
						+ "\"name\": \"Testing Selenium 1 with Java on Sauce\"}",
				"http://saucelabs.com/");
		selenium.start();
		this.selenium = selenium;
	}

	public void testSauce() throws Exception {
		this.selenium.open("/test/guinea-pig");
		assertEquals("I am a page title - Sauce Labs", this.selenium.getTitle());
	}

	public void tearDown() throws Exception {
		this.selenium.stop();
	}
}
