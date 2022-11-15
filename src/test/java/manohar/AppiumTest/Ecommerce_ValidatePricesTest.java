package manohar.AppiumTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_ValidatePricesTest extends BaseTest {
	
	@Test
	public void validateCartPricesTest() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Manohar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		List<WebElement> Productprices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int Productscount=Productprices.size();
		System.out.println(Productscount);
		double totalAmount=0;
		for(int i=0;i<Productscount;i++)
		{
			String amountstring=Productprices.get(i).getText();
			Double price=getFormattedAmount(amountstring);		
			totalAmount=totalAmount+price; // 160.97+120.0=280.97
			System.out.println(totalAmount);
		}
			String TotalAmount=	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			Double displayedsum=getFormattedAmount(TotalAmount);
			System.out.println(displayedsum);
			Assert.assertEquals(displayedsum, totalAmount);
			WebElement terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			longPressAction(terms);
		String termspopupalerttitle=driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
			System.out.println("Terms popup title is : "+termspopupalerttitle);
			Assert.assertEquals(termspopupalerttitle, "Terms Of Conditions");
			Thread.sleep(2000);
			
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("android.widget.CheckBox")).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			Thread.sleep(10000);
			/*String Googletext=driver.findElement(By.xpath("//android.widget.Image[@text='Google']")).getText();
			System.out.println("Google Text displyed : "+Googletext);
			Assert.assertEquals(Googletext, "Google");
			*/
			Set<String> contexts=driver.getContextHandles();
			for (String contextNames : contexts) {
				System.out.println(contextNames);
				
			}
			
			driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
			driver.findElement(By.name("q")).sendKeys("Appium");
			Thread.sleep(4000);
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			driver.context("NATIVE_APP");
			
			
			
			
			
			
			
			
			
			
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	


