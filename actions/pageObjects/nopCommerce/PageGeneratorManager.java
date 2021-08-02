package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	
	private static SearchPageObject searchPage;
	private static ShippingAndReturnPageObject shippingAndReturnPage;
	private static SiteMapPageObject siteMapPage;
	private static MyAccountFooterPageObject myAccountFooterPage;
	private static WishListHeaderPageObject wishListHeaderPage;
	
	private PageGeneratorManager() {
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static ShippingAndReturnPageObject getShippingAndReturnPage(WebDriver driver) {
		if(shippingAndReturnPage == null) {
			shippingAndReturnPage = new ShippingAndReturnPageObject(driver);
		}
		return shippingAndReturnPage;
	}
	
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		if(siteMapPage == null) {
			siteMapPage = new SiteMapPageObject(driver);
		}
		return siteMapPage;
	}
	
	public static MyAccountFooterPageObject getMyAccountFooterPage(WebDriver driver) {
		if(myAccountFooterPage == null) {
			myAccountFooterPage = new MyAccountFooterPageObject(driver);
		}
		return myAccountFooterPage;
	}
	
	public static WishListHeaderPageObject getWishListHeaderPage(WebDriver driver) {
		if(wishListHeaderPage == null) {
			wishListHeaderPage = new WishListHeaderPageObject(driver);
		}
		return wishListHeaderPage;
	}
}
