package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkBoxes = By.linkText("Checkboxes");

	public WebElement checkBoxes() {
		return driver.findElement(checkBoxes);
	}
	

}
