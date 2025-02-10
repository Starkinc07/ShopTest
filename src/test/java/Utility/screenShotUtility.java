package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import Ecom.Shop.Base;

public class screenShotUtility extends Base{

	// Utility method to take a screenshot on failure
		public String captureScreenshot(WebDriver driver, ITestResult result) {
			// Create a timestamp for the screenshot file name
			String testName = result.getName();
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String screenshotName = testName + "_" + timestamp + ".png";

			// Get the name of the class (for the folder structure)
			//String className = this.getClass().getSimpleName();
			//String className = result.getTestClass().getName();
			String className = result.getTestClass().getRealClass().getSimpleName();
			System.out.println(className);
			
			// Create a folder for the class if it doesn't exist
			File classFolder = new File("screenshots/" + className);
			if (!classFolder.exists()) {
				classFolder.mkdirs(); // Create the folder
			}

			// Cast driver to TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
System.out.println(driver);
			// Capture screenshot and store it as a file
			File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Define the destination path where the screenshot will be saved
			File destinationFile = new File(classFolder, screenshotName);

			String filePath = destinationFile.getAbsolutePath();

			try {
				// Save the screenshot to the specified location
				FileUtils.copyFile(screenshotFile, destinationFile);
				System.out.println("Screenshot saved to " + destinationFile.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("Failed to save screenshot: " + e.getMessage());
			}
			return filePath;
		}

}
