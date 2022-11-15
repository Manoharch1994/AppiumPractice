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

public class LongPress extends BaseTest {
	
		
		//Actual Scripts will start from Here
	
	//Used to Enter WifiName
	@Test	
	public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
		//Xpath,id, accessibilityId, classname,androidUIAutomator
		
		
		//ConfigureAppium();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Xpath- //tagname[@attributename='value']
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
	WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
	/*	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",2000));
		*/
		longPressAction(element);
		
		String SMenu=driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		System.out.println(SMenu+" - is Displayed atfer performed Long Press.");
		Assert.assertEquals(SMenu,"Sample menu");
		
		Thread.sleep(5000);
	}
	

	
	
}
