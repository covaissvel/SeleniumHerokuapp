package pageObjectModelTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import common.Base;
import pageObjectRepository.Repo;

public class RepoTest extends Base{
	
	//selection of check boxes
	@Test
	public void testCheckBox() {
		webdriver = initialize();
		webdriver.get("http://the-internet.herokuapp.com/checkboxes");
		 Repo repo = new Repo(webdriver);
		 List<WebElement> checkboxes = repo.checkBoxes();
		 
		 //for selecting the first check box
		 checkboxes.get(0).click();	

		 //assert if check box is selected
		 assertTrue(checkboxes.get(0).isSelected());
	
	}
	

}
