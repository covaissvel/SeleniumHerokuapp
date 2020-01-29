package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Repo {
	
	WebDriver driver;
	Repo repo;
	
	public Repo(WebDriver driver) {
		this.driver = driver;
	}
	
	//checkboxes by list
	By checkBoxesByList = By.xpath("//*[@id='checkboxes']/input");

	public List<WebElement> checkBoxes() {
		return driver.findElements(checkBoxesByList);
	}
	
	//dropdown
	By dropdownById = By.id("dropdown");
	
	public WebElement dropdown() {
		return driver.findElement(dropdownById);
	}
	
}
