package com.testing;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(3L)).ignoring(NoSuchElementException.class);
    }

    protected void click_element(By locator){
        get_WebElement(locator).click();
    }

    protected WebElement get_WebElement(By locator) {
        WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    protected void wait_for_element(By locator){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String get_page_title(){
        return this.driver.getTitle();
    }

    public String get_page_URL(){
        return this.driver.getCurrentUrl();
    }

    public WebDriver get_Driver(){
        return this.driver;
    }
}
