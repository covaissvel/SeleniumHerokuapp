package pageObjectModelTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trial {
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ssubra368/Documents/Github/Workbench_Automation/src/main/resources/BrowserSpecificDrivers/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://wbapp-dt-1q.ula.comcast.net:7011/commsales/bundleBuilderDelegate.do?method=delegate&clearErrors=true&bbtype=legacy&opportunityObjid=1095235939");
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.findElement(By.id("product-internet")).click();
//		driver.findElement(By.id("CWP000022")).click();
//		driver.findElement(By.xpath("//li[text()='Self Install']")).click();
////		System.out.println(driver.findElement(By.xpath("//div[@class='modal-dialog']")).isDisplayed());
////		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//
//		System.out.println();
		
		
		 DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
	        capabilities.setCapability("networkConnectionEnabled", true);
	        capabilities.setCapability("browserConnectionEnabled", true);
		String remoteUrl = "http://localhost:4444/wd/hub";
		RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
		driver.get("https://www.programcreek.com/java-api-examples/?api=org.openqa.selenium.remote.RemoteWebDriver");
		
	}

}
