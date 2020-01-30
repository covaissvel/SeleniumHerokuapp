package common;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver webdriver;
	public WebDriverWait wait;

	public WebDriver initialize() {
		
		Properties properties = new Properties();

		try {
			properties.load(Base.class.getClassLoader().getResourceAsStream("project.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = properties.getProperty("browser");
		String system  = properties.getProperty("system");

		switch (browser) {
		case "chrome":
			if("personal".equalsIgnoreCase(system)) {
				System.setProperty("webdriver.chrome.driver",
						"src/main/resources/browserDrivers/chromedriver.exe");
			}else {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ssubra368\\Documents\\Personal\\Courses\\Downloaded\\chromedriver.exe");
			}
			webdriver = new ChromeDriver();
			break;
		case "firefox":
			if("personal".equalsIgnoreCase(system)) {
				System.setProperty("webdriver.gecko.driver",
						"src/main/resources/browserDrivers/geckodriver.exe");
			}else {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\ssubra368\\Documents\\Personal\\Courses\\Downloaded\\geckodriver.exe");
			}
			
			webdriver = new FirefoxDriver();
			break;
		case "ie":
			// fill data
			break;
		default:
			System.out.println("browser driver not found!");
			break;
		}
		
		//set implicit wait
		webdriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//set explicit wait
		wait = new WebDriverWait(webdriver,10);

		return webdriver;
	}
}
