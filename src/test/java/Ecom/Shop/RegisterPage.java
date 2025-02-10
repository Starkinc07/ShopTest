package Ecom.Shop;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Page;

public class RegisterPage extends Base {

	@Test
	public void registerTest() {
		
		System.out.println("hello");
		Page pom = new Page(driver);
		pom.getRegisterLink().click();
		pom.getMaleBtn().click();
		pom.getFirstName().sendKeys("Abc2");
		pom.getLastName().sendKeys("xyz");
		pom.getRegisterEmail().sendKeys("abcxyz5@mail.com");
		pom.getRegPassword().sendKeys("abcdef");
		pom.getRegConfirmPass().sendKeys("abcdef");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pom.getRegisterBtn().submit();
		Assert.assertEquals("Logou","Logout");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
