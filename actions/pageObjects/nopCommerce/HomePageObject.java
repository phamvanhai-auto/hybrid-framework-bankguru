package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	//ham khoi tao
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}
//	public SearchPageObject openSearchPage() {
//		waitForElementVisible(driver, HomePageUI.SEARCH_PAGE_FOOTER);
//		clickToElement(driver, HomePageUI.SEARCH_PAGE_FOOTER);
//		return PageGeneratorManager.getSearchPage(driver);
//	}
//	public WishListHeaderPageObject openWishListHeader() {
//		waitForElementVisible(driver, HomePageUI.WISHLIST_PAGE_HEADER);
//		clickToElement(driver, HomePageUI.WISHLIST_PAGE_HEADER);
//		return PageGeneratorManager.getWishListHeaderPage(driver);
//	}

}
