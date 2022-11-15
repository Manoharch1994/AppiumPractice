package manohar.AppiumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_AddtoCartTest extends BaseTest {
	
	@Test
	public void AddtoCart() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Manohar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		int ProductCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		System.out.println("Product Count is - "+ProductCount);
		
		for(int i=0;i<ProductCount;i++) {
			
		String ProductName =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		if (ProductName.equalsIgnoreCase("Jordan 6 Rings")) 
		{
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();	
		}
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		
		/*String CartProductName=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println("Product Name is Displayed in Cart is:  "+CartProductName);
		Assert.assertEquals(CartProductName,"Jordan 6 Rings");
		*/
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
