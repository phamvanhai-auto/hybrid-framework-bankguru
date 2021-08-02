package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SiteMapPageUI;
import pageUIs.nopCommerce.WishListHeaderPageUI;

public class WishListHeaderPageObject extends BasePage{
	WebDriver driver;
	
	public WishListHeaderPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public SiteMapPageObject openSiteMapPage() {
//		waitForElementVisible(driver, WishListHeaderPageUI.SITE_MAP_PAGE_FOOTER);
//		clickToElement(driver, WishListHeaderPageUI.SITE_MAP_PAGE_FOOTER);
//		return PageGeneratorManager.getSiteMapPage(driver);
//	}
	
}
