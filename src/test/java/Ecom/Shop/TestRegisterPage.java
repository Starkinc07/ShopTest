package Ecom.Shop;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Page;

public class TestRegisterPage extends Base {

	@Test
	public void registerTest() {
		
		System.out.println("hello");
		Page pom = new Page(driver);
		pom.getRegisterLink().click();
		pom.getMaleBtn().click();
		pom.getFirstName().sendKeys("Abc2");
		pom.getLastName().sendKeys("xyz");
		pom.getRegisterEmail().sendKeys("abcxyz44@mail.com");
		pom.getRegPassword().sendKeys("abcdef");
		pom.getRegConfirmPass().sendKeys("abcdef");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pom.getRegisterBtn().submit();
		Assert.assertEquals("Logout","Logout");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
