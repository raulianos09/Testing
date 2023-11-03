import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.Pages.HomePage;
import com.testing.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
 
    WebDriver driver;
    
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void breakdown(){
        driver.quit();
    }

    @Test
    public void PageTitleTest(){
        LoginPage loginPage = new LoginPage(this.driver);
        Assert.assertEquals(loginPage.get_page_title(), "Swag Labs", "Login page title does not match the expected one!");
    }

    @Test
    public void TestSuccessfullLogin(){
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.enter_username("standard_user");
        loginPage.enter_password("secret_sauce");
        loginPage.click_login_button();
        
        HomePage homePage = new HomePage(loginPage.get_Driver());

        Assert.assertEquals(homePage.get_page_URL(),"https://www.saucedemo.com/inventory.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
