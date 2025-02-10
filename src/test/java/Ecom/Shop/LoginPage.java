package Ecom.Shop;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
    @Test
    public void loginTest() {
    	Page pom = new Page(driver);
    	pom.getLoginLink().click();
    	pom.getEmailField().sendKeys("abcxyz5@mail.com");
    	pom.getPasswordField().sendKeys("abcdef");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	pom.getLoginButton().submit();
    	
    	Assert.assertEquals("pas","pass");
    }

}
