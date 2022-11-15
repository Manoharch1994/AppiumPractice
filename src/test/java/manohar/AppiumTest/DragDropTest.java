package manohar.AppiumTest;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDropTest extends BaseTest {
	
		
		//Actual Scripts will start from Here
	
	//Used to Enter WifiName
	@Test	
	public void DragDropdemoTest() throws MalformedURLException, InterruptedException {
		
		//Xpath,id, accessibilityId, classname,androidUIAutomator		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();	
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 830,
			    "endY", 730
			));
		Thread.sleep(3000);
		String successText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println("Success Text Found after Drag: " +successText);
		Assert.assertEquals(successText,"Dropped!");
		
		
		
		
	
		
		
		
		
		
	}
	

	
	
}
