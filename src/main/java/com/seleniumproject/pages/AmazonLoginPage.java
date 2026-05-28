package com.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signInNav = By.id("nav-link-accountList");
    private final By emailInput = By.id("ap_email");
    private final By continueButton = By.id("continue");
    private final By passwordInput = By.id("ap_password");
    private final By submitButton = By.id("signInSubmit");

    public AmazonLoginPage(WebDriver driver, int waitSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
    }

    public void openSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInNav)).click();
    }

    public void login(String email, String password) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElement.clear();
        emailElement.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}

