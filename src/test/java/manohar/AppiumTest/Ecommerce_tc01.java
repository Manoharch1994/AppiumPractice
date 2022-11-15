package manohar.AppiumTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc01 extends BaseTest {
	
	@Test
	public void formFill() throws InterruptedException {
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Manohar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	/*	Thread.sleep(3000);
		String ProductspageTitle=driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).getText();
		System.out.println("Page Title Displayed is: "+ProductspageTitle);
		Assert.assertEquals(ProductspageTitle,"Products");
	*/	
		
		//Used to get Toast Message Validation.
	String ToastMsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	System.out.println(ToastMsg);
	Assert.assertEquals(ToastMsg,"Please enter your name");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
