package common;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver webdriver;

	public WebDriver initialize() {
		Properties properties = new Properties();

		try {
			properties.load(Base.class.getClassLoader().getResourceAsStream("project.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = properties.getProperty("browser");

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"/SeleniumHerokuapp/src/main/resources/browserDrivers/chromedriver.exe");
			webdriver = new ChromeDriver();
			break;
		case "firefox":
			// fill data
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

		return webdriver;
	}
}
