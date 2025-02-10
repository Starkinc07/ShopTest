package Ecom.Shop;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObject.Page;

public class ProductPage extends Base{
	@Test
	public void product() throws InterruptedException, IOException {
		
		Page pom = new Page(driver);
		Actions ac = new Actions(driver);
//		ac.moveToElement(pom.getComputerHeader()).perform();
//		ac.moveToElement(pom.getDesktopsSubHeader()).perform();
//		pom.getDesktopsSubHeader().click();
		
//		ac.moveToElement(pom.getAbtn()).perform();
//		ac.clickAndHold();
//		ac.moveToElement(pom.getBbtn()).perform();
//		ac.release().perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,130)");
//		Thread.sleep(3000);
//		ac.dragAndDrop(pom.getAbtn(),pom.getBbtn()).perform();
//		ac.release().perform();
		
//		pom.getFileUpload().click();
//		Runtime.getRuntime().exec("C:\\Users\\Admin\\OneDrive\\Desktop\\fileupload.exe");
//		Thread.sleep(7000);
		
		
		Select sc = new Select(pom.getdropdown1());
		Select sc2 = new Select(pom.getdropdown2());
		sc.selectByVisibleText("India");
		Thread.sleep(3000);
		System.out.println(sc.isMultiple());
		if(sc2.isMultiple()) {
			Thread.sleep(4000);
			sc2.selectByIndex(6);
			Thread.sleep(4000);
			sc2.selectByValue("Sept");
			Thread.sleep(4000);
			sc2.selectByVisibleText("December");	
			Thread.sleep(4000);
			sc2.selectByIndex(5);
			Thread.sleep(4000);
			sc2.deselectByIndex(5);
			Thread.sleep(4000);
			sc2.deselectAll();
		}
		
		
		
	}

}
