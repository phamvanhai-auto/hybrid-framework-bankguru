package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SearchPageUI;
import pageUIs.nopCommerce.ShippingAndReturnPageUI;

public class ShippingAndReturnPageObject extends BasePage{
	WebDriver driver;
	
	public ShippingAndReturnPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public SiteMapPageObject openSiteMapPage() {
//		waitForElementVisible(driver, ShippingAndReturnPageUI.SITE_MAP_PAGE_FOOTER);
//		clickToElement(driver, ShippingAndReturnPageUI.SITE_MAP_PAGE_FOOTER);
//		return PageGeneratorManager.getSiteMapPage(driver);
//	}
	
}
