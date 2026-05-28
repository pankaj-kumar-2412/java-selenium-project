package com.seleniumproject.tests;

import com.seleniumproject.config.ConfigReader;
import com.seleniumproject.core.DriverFactory;
import com.seleniumproject.pages.AmazonLoginPage;
import com.seleniumproject.pages.AmazonProductPage;
import com.seleniumproject.pages.AmazonSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AmazonAddToCartTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void loginAndAddProductToCart() {
        String baseUrl = ConfigReader.get("amazon.base.url", "https://www.amazon.in");
        String email = ConfigReader.require("amazon.email");
        String password = ConfigReader.require("amazon.password");
        String productName = ConfigReader.get("amazon.product.query", "wireless mouse");
        int waitSeconds = ConfigReader.getInt("wait.seconds", 20);

        driver.get(baseUrl);

        AmazonLoginPage loginPage = new AmazonLoginPage(driver, waitSeconds);
        loginPage.openSignIn();
        loginPage.login(email, password);

        AmazonSearchPage searchPage = new AmazonSearchPage(driver, waitSeconds);
        searchPage.searchFor(productName);
        searchPage.openFirstResultInSameTab();

        AmazonProductPage productPage = new AmazonProductPage(driver, waitSeconds);
        productPage.addCurrentProductToCart();

        Assertions.assertTrue(driver.getCurrentUrl().contains("amazon"), "Expected browser to remain on Amazon domain.");
    }
}

