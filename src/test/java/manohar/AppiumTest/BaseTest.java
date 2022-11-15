package manohar.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Manohar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				service.start();
				
				
				UiAutomator2Options options=new UiAutomator2Options();
				options.setDeviceName("Manoharemulator");
				options.setChromedriverExecutable("C:\\Users\\Manohar\\eclipse-workspace\\AppiumTest\\src\\test\\java\\Drivers\\chromedriver.exe");
				//options.setApp("C:\\Users\\Manohar\\eclipse-workspace\\AppiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				options.setApp("C:\\Users\\Manohar\\eclipse-workspace\\AppiumTest\\src\\test\\java\\resources\\General-Store.apk");

			
				 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",2000));
		
		
		
	}
	
public void scrollToEndAction() {
	boolean canScrollMore;
	do
	{
	 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
	}while(canScrollMore);
		
}
public void swipeAction(WebElement ele,String direction) {
	
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId",((RemoteWebElement)ele).getId(),
		    "direction", direction,
		    "percent", 0.75
		));
}

public void OkCancelDialoguewithMsg() throws InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("App")).click();	
	
	driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
			
	driver.findElement(By.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with a message']")).click();
	
	String Alert_Text=driver.findElement(By.id("android:id/alertTitle")).getText();
	System.out.println("Text Found in Alert -:  " +Alert_Text);
	Assert.assertEquals(Alert_Text,driver.findElement(By.id("android:id/alertTitle")).getText());
	Thread.sleep(5000);
	
	driver.findElement(By.id("android:id/button1")).click();
	
	
}
public void OkCancelwithLongMsg() throws InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("App")).click();	
	driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
	driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
	Thread.sleep(3000);
	String HeaderTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
	System.out.println(HeaderTitle);
	Assert.assertEquals(HeaderTitle, driver.findElement(By.id("android:id/alertTitle")).getText());
	Thread.sleep(3000);
	driver.findElement(By.id("android:id/button3")).click();
	
}
public void DeviceRotationLandscapeCopyClipBoardtextKeyEventsTest() throws InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	
	//Xpath- //tagname[@attributename='value']
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	
	driver.findElement(By.id("android:id/checkbox")).click();
	//Used to Rotate the Device in LandScape mode.
	DeviceRotation landscape=new DeviceRotation(0, 0, 90);
	driver.rotate(landscape);
	
	driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	
	String Wifi_AlertText=driver.findElement(By.id("android:id/alertTitle")).getText();
	System.out.println(Wifi_AlertText);
	Assert.assertEquals(Wifi_AlertText,"WiFi settings");
	//copy paste
	//copy to  clipboard- paste it  clipboard.
	driver.setClipboardText("ManoharWifi");	
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	Thread.sleep(2000);
	driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(2000);
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
	Thread.sleep(2000);
	

}

public Double getFormattedAmount(String amount) {
	
	
	Double price=Double.parseDouble(amount.substring(1));
	return price;
}








	
	@AfterClass
	public void tearDown() {
		driver.quit();
		//Stop Appium Server
		service.stop();
		
	}
	

}
