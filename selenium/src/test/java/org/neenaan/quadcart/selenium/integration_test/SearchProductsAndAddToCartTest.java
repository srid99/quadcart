package org.neenaan.quadcart.selenium.integration_test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.neenaan.quadcart.selenium.conf.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.Selenium;

public class SearchProductsAndAddToCartTest extends SeleniumBaseTest {

    @Test
    public void testSearchProducts() {
        final Selenium selenium = selenium();
        final WebDriver driver = driver();

        selenium.type( "searchbox", "a" );
        selenium.keyPress( "searchbox", "\\13" );
        selenium.waitForPageToLoad( "2000" );

        final List<WebElement> products = driver.findElements( By.tagName( "product" ) );
        assertThat( products.size(), is( 20 ) );

        final WebElement product = products.get( 6 );
        assertThat( product.getAttribute( "data-id" ), is( "7" ) );
        assertThat( product.getAttribute( "data-name" ), is( "Tyre Radial" ) );
        assertThat( product.getAttribute( "data-price" ), is( "3000" ) );
    }

    @Test
    public void testAddingSameProductSeveralTimesToCart() {
        final WebDriver driver = driver();

        final List<WebElement> products = driver.findElements( By.tagName( "product" ) );
        final WebElement cart = driver.findElement( By.id( "product-details" ) );

        assertThat( cart.findElements( By.tagName( "div" ) ).size(), is( 1 ) );

        products.get( 7 ).click();

        assertThat( cart.findElements( By.tagName( "div" ) ).size(), is( 2 ) );

        assertThat( cart.findElements( By.tagName( "total" ) ).get( 1 ).getText(), is( "4000" ) );
        assertThat( cart.findElement( By.tagName( "input" ) ).getAttribute( "value" ), is( "1" ) );

        products.get( 7 ).click();
        products.get( 7 ).click();
        products.get( 7 ).click();
        products.get( 7 ).click();

        assertThat( cart.findElements( By.tagName( "div" ) ).size(), is( 2 ) );

        assertThat( cart.findElements( By.tagName( "total" ) ).get( 1 ).getText(), is( "20000" ) );
        assertThat( cart.findElement( By.tagName( "input" ) ).getAttribute( "value" ), is( "5" ) );
    }

    @Test
    public void testAddingVariousProductsToCart() {
        final WebDriver driver = driver();

        final List<WebElement> products = driver.findElements( By.tagName( "product" ) );
        final WebElement cart = driver.findElement( By.id( "product-details" ) );

        products.get( 4 ).click();
        products.get( 8 ).click();
        products.get( 12 ).click();
        products.get( 6 ).click();
        products.get( 4 ).click();

        assertThat( cart.findElements( By.tagName( "div" ) ).size(), is( 6 ) );
        assertThat( cart.findElements( By.tagName( "total" ) ).get( 2 ).getText(), is( "6000" ) );
        assertThat( cart.findElements( By.tagName( "input" ) ).get( 1 ).getAttribute( "value" ), is( "2" ) );
    }

    @Test
    public void testToClearTheProductsFromCart() {
        final WebDriver driver = driver();

        final WebElement cart = driver.findElement( By.id( "product-details" ) );

        final WebElement products = driver.findElement( By.id( "cart-details" ) );
        final WebElement clear = products.findElement( By.tagName( "input" ) );

        clear.click();

        assertThat( cart.findElements( By.tagName( "div" ) ).size(), is( 1 ) );
    }

    @Test
    public void testNoProductsFound() {
        final Selenium selenium = selenium();
        final WebDriver driver = driver();

        selenium.type( "searchbox", "aa" );
        selenium.keyPress( "searchbox", "\\13" );
        selenium.waitForPageToLoad( "2000" );

        final WebElement products = driver.findElement( By.id( "products" ) );

        assertThat( products.findElement( By.tagName( "li" ) ).getText(), is( "No products found." ) );
    }
}
