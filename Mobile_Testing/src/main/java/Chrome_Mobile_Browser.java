import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.Assert;


//Desired Capablitites to run Appium test on mobile browser.
public class Chrome_Mobile_Browser {
	public static void main(String[] args)throws MalformedURLException {
		
	
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	File appDir = new File("src/main/java");
	File app = new File(appDir, "ApiDemos-debug.apk");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "chethan");
	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

	AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	driver.findElement(By.cssSelector("a[href*='products']")).click();
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)", "");
	String text =driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
	Assert.assertEquals(text, "Devops");


}
}

