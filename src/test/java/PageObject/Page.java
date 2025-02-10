package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Ecom.Shop.Base;

public class Page extends Base {
 
	
    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login page
    public WebElement getLoginLink() {
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    
    public WebElement getEmailField() {
        return driver.findElement(By.name("Email"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//input[@value='Log in']"));
    }
    
    // Register page
	   
    public WebElement getRegisterLink() {
        return driver.findElement(By.xpath("//a[@href='/register']"));
    }
    
    public WebElement getMaleBtn() {
        return driver.findElement(By.id("gender-male"));
    }
    
    public WebElement getFemaleBtn() {
        return driver.findElement(By.id("gender-female"));
    }
    
    public WebElement getFirstName() {
        return driver.findElement(By.id("FirstName"));
    }
    
    public WebElement getLastName() {
        return driver.findElement(By.id("LastName"));
    }
    
    public WebElement getRegisterEmail() {
        return driver.findElement(By.id("Email"));
    }
    
    public WebElement getRegPassword() {
        return driver.findElement(By.id("Password"));
    }
    public WebElement getRegConfirmPass() {
        return driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement getRegisterBtn() {
        return driver.findElement(By.id("register-button"));
    }

    // Product
    public WebElement getComputerHeader() {
        return driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a[@href='/computers']"));
    }
    
    public WebElement getDesktopsSubHeader() {
        return driver.findElement(By.xpath("//ul[@class='top-menu']//ul/li/a[@href='/desktops']"));
    }
    
    public WebElement getSortDropdown() {
        return driver.findElement(By.xpath("//select[@id='products-orderby']"));
    }
    
    public WebElement getAbtn() {
        return driver.findElement(By.xpath("//li[@name='A']"));
    }
    public WebElement getBbtn() {
        return driver.findElement(By.xpath("//li[@name='B']"));
    }
    
    public WebElement getFileUpload() {
        return driver.findElement(By.xpath("//div[@class='dz-default dz-message']"));
    }
  
    
    //===
    public WebElement getdropdown1() {
        return driver.findElement(By.xpath("//select[@name='country']"));
    }
    public WebElement getdropdown2() {
        return driver.findElement(By.xpath("//select[@name='Month']"));
    }
  
 

}
