package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public ShippingAndReturnPageObject openShippingAndReturnPage() {
//		waitForElementVisible(driver, SearchPageUI.SHIPPING_RETURN_PAGE_FOOTER);
//		clickToElement(driver, SearchPageUI.SHIPPING_RETURN_PAGE_FOOTER);
//		return PageGeneratorManager.getShippingAndReturnPage(driver);
//
//	}
	
}
