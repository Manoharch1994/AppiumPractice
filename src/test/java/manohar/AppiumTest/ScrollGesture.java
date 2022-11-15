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

public class ScrollGesture extends BaseTest {
	
		
		//Actual Scripts will start from Here
	
	//Used to Enter WifiName
	@Test	
	public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
		//Xpath,id, accessibilityId, classname,androidUIAutomator
		
		
		//ConfigureAppium();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();		
	//Scroll Type-1:
	//This Method used to scroll Particular element.
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	
		//This Method is used to when you have no prior idea.
		scrollToEndAction();
		
		//Thread.sleep(2000);
		
		
		
		
		
	}
	

	
	
}
