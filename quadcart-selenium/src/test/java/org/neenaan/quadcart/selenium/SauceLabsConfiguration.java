package org.neenaan.quadcart.selenium;

import com.thoughtworks.selenium.DefaultSelenium;

public class SauceLabsConfiguration {

	public static DefaultSelenium create(final String testCaseName) {
		DefaultSelenium selenium = new DefaultSelenium(
				"ondemand.saucelabs.com",
				80,
				"{\"username\": \"neenaan\","
						+ "\"access-key\": \"0fbd45d1-1429-45bf-af60-34c12eff93de\","
						+ "\"os\": \"Windows 2003\","
						+ "\"browser\": \"firefox\","
						+ "\"browser-version\": \"9\"," + "\"name\": \""
						+ testCaseName + "\"}",
				"http://quadcart.neenaan.cloudbees.net/");
		selenium.start();
		return selenium;
	}

}
