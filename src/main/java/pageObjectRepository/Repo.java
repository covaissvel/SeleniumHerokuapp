package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Repo {
	
	WebDriver driver;
	
	public Repo(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkBoxes = By.id("checkboxes");

	public List<WebElement> checkBoxes() {
		return driver.findElements(checkBoxes);
	}
	

}
