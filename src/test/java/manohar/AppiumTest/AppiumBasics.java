package manohar.AppiumTest;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {
	
		
		//Actual Scripts will start from Here
	
	//Used to Enter WifiName
	@Test	
	public void WifiSettingsName() throws MalformedURLException {
		
		//Xpath,id, accessibilityId, classname,androidUIAutomator
		
		
		//ConfigureAppium();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//Xpath- //tagname[@attributename='value']
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String Wifi_AlertText=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(Wifi_AlertText);
		Assert.assertEquals(Wifi_AlertText,"WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("ManoharWifi");
		
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	
	}
	
	
	
	
}
