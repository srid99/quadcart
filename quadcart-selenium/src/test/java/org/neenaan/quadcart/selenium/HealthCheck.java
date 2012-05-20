package org.neenaan.quadcart.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;

public class HealthCheck {
	private static DefaultSelenium SELENIUM = SauceLabsConfiguration
			.create("Health check for Quadcart application");

	@Test
	public void testSauce() throws Exception {
		HealthCheck.SELENIUM.open("/");
		assertEquals(0,
				HealthCheck.SELENIUM.getBodyText().indexOf("Hello World!"));
	}

	@AfterClass
	public static void after() throws Exception {
		HealthCheck.SELENIUM.stop();
	}
}
