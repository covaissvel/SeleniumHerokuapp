package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Repo {
	WebDriver driver;
	WebDriverWait wait;

	// common methods
	public boolean isElementPresent(By byElement) {
		try {

			if (driver.findElements(byElement).size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Repo(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// checkboxes by list
	By checkBoxesByList = By.xpath("//*[@id='checkboxes']/input");

	public List<WebElement> checkBoxes() {
		return driver.findElements(checkBoxesByList);
	}

	// dropdown
	By dropdownById = By.id("dropdown");

	public WebElement dropdown() {
		return driver.findElement(dropdownById);
	}

	// entry-ad
	By modalClose = By.xpath("//div[@class='modal-footer']/p");

	public WebElement modalWindowClose() {
		return driver.findElement(modalClose);
	}

	public By modalWindow = By.cssSelector("#modal > div.modal");

	public Boolean isModalWindowDisplayed() {
		try {
			WebElement modalWindowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
			return modalWindowElement.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	By restartAd = By.cssSelector("a#restart-ad");

	public void clickRestartAd() {
		driver.findElement(restartAd).click();
	}

	// By iFrame
	By iFrameId = By.id("mce_0_ifr");

//	public WebElement getIFrame() {
//		
//		try {
//			if(isElementPresent(iFrameId)) {
//				driver.switchTo().frame(driver.findElement(iFrameId));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	public void switchToDefault() {
		try {
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
