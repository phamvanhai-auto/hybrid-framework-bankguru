package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_FOOTER_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER_LINK);
	}

}
