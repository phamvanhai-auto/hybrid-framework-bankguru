package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountFooterPageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class MyAccountFooterPageObject extends BasePage{
	WebDriver driver;
	
	public MyAccountFooterPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public HomePageObject openHomePage() {
//		waitForElementVisible(driver, MyAccountFooterPageUI.HOME_PAGE);
//		clickToElement(driver, MyAccountFooterPageUI.HOME_PAGE);
//		return PageGeneratorManager.getHomePage(driver);
//	}
	
}
