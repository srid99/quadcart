package org.neenaan.quadcart.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;

public class HealthCheckTest {
	private static DefaultSelenium SELENIUM = SauceLabsConfiguration
			.create("Health check for Quadcart application");

	@Test
	public void testApplicationLoaded() throws Exception {
		HealthCheckTest.SELENIUM.open("/");
		assertEquals(0,
				HealthCheckTest.SELENIUM.getBodyText().indexOf("Hello World!"));
	}

	@AfterClass
	public static void after() throws Exception {
		HealthCheckTest.SELENIUM.stop();
	}
}
