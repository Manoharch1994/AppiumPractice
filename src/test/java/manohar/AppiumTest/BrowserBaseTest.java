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

public class BrowserBaseTest {
	
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
				//options.setApp("C:\\Users\\Manohar\\eclipse-workspace\\AppiumTest\\src\\test\\java\\resources\\General-Store.apk");
				
				options.setCapability("browserName","Chrome");
			
				 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
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
