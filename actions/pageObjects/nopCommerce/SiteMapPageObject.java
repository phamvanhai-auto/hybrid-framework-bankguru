package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SearchPageUI;
import pageUIs.nopCommerce.SiteMapPageUI;

public class SiteMapPageObject extends BasePage{
	WebDriver driver;
	
	public SiteMapPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public MyAccountFooterPageObject openMyAccountFooterPage() {
//		waitForElementVisible(driver, SiteMapPageUI.MY_ACCOUNT_PAGE_FOOTER);
//		clickToElement(driver, SiteMapPageUI.MY_ACCOUNT_PAGE_FOOTER);
//		return PageGeneratorManager.getMyAccountFooterPage(driver);
//	}
	
}
