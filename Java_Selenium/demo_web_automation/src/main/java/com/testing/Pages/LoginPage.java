package com.testing.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.BasePage;

public class LoginPage extends BasePage {

    private By username_input_field = By.id("user-name");
    private By password_input_field = By.id("password");
    private By login_button = By.id("login-button");
    private By login_logo = By.xpath("//*[@class='login_logo']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait_for_element(login_logo);
    }

    public void enter_username(String username) {
        get_WebElement(this.username_input_field).sendKeys(username);
    }

    public void enter_password(String password) {
        get_WebElement(this.password_input_field).sendKeys(password);
    }

    public void click_login_button() {
        click_element(this.login_button);
    }

    
}
