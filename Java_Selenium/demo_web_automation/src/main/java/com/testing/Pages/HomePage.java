package com.testing.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.BasePage;

public class HomePage extends BasePage{

    private By app_logo = By.xpath("//*[@class = 'app_logo']");


    public HomePage(WebDriver driver) {
        super(driver);
        this.wait_for_element(app_logo);
    }
    
}
