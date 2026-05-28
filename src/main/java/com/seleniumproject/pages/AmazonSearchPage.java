package com.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonSearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox = By.id("twotabsearchtextbox");
    private final By firstResultLink = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a");

    public AmazonSearchPage(WebDriver driver, int waitSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
    }

    public void searchFor(String query) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        box.clear();
        box.sendKeys(query);
        box.sendKeys(Keys.ENTER);
    }

    public void openFirstResultInSameTab() {
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(firstResultLink));
        String productUrl = firstResult.getAttribute("href");
        driver.get(productUrl);
    }
}

