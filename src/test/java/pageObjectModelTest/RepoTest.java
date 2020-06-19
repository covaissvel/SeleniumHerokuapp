package pageObjectModelTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.Base;
import pageObjectRepository.Repo;

public class RepoTest extends Base{
	
	SoftAssert softAssert = new SoftAssert();
	Repo repo;
	
	@BeforeClass
	public void startup() {
		webdriver = initialize();
		repo = new Repo(webdriver, wait);
	}
	
	@Test
	public void testHerokaupp() {
		
		//testCheckBox
		testCheckBox();
		
		//dropdown
		testDropDown();
		
		//basicAuth
		basicAuth();
		
		//modalwindow
		testModalWindow();
		
	}
	
	//selection of check boxes
	public void testCheckBox() {

		webdriver.get("http://the-internet.herokuapp.com/checkboxes");

		 List<WebElement> checkboxes = repo.checkBoxes();
		 
		 //for selecting the first check box
		 checkboxes.get(0).click();	

		 //assert if check box is selected
		 softAssert.assertTrue(checkboxes.get(0).isSelected());
	}
	
	//test drop down
	public void testDropDown() {
		webdriver.get("http://the-internet.herokuapp.com/dropdown");
		
		Select select = new Select(repo.dropdown());
		
		//selecting a specific value
		select.selectByValue("1");
		
		//asserting
		softAssert.assertTrue(repo.dropdown().getText().equalsIgnoreCase("Option 1"));
	}
	
	//basic auth
	public void basicAuth() {
		webdriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
	
	
	
	//modal window
	public void testModalWindow() {
		webdriver.get("https://the-internet.herokuapp.com/entry_ad");
		
		//check whether modal window is displayed
		if(repo.isModalWindowDisplayed()) {
			
			repo.modalWindowClose();
			
		}else {
			//restart ad
			repo.clickRestartAd();
			
			repo.modalWindowClose();
		}
	}
	
	//frame 
	public void testFrame() {
		webdriver.get("https://the-internet.herokuapp.com/iframe");
		
		//switch to frame
//		repo.switchToIFrame();
		
		
		
	}
	
	@AfterClass
	public void teardown(){
		webdriver.quit();
	}


}
