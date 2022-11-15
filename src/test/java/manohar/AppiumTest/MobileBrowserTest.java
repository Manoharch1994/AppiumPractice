package manohar.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest() throws InterruptedException {
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Appium");
		Thread.sleep(4000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
