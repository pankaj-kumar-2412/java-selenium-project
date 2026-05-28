package com.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductPage {
    private final WebDriverWait wait;

    private final By addToCartButton = By.id("add-to-cart-button");
    private final By addedToCartConfirmation = By.cssSelector("#NATC_SMART_WAGON_CONF_MSG_SUCCESS, #attachDisplayAddBaseAlert");

    public AmazonProductPage(WebDriver driver, int waitSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
    }

    public void addCurrentProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartConfirmation));
    }
}

