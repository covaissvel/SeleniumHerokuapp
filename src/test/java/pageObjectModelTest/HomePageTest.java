package pageObjectModelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjectRepository.HomePage;

public class HomePageTest {
	
	@Test
	public void testCheckBoxes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sakthivel\\Documents\\Personal\\Courses\\Downloaded_jars\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.checkBoxes().click();
	}

}
