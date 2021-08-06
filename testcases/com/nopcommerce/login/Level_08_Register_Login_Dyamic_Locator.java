package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountFooterPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.ShippingAndReturnPageObject;
import pageObjects.nopCommerce.SiteMapPageObject;
import pageObjects.nopCommerce.WishListHeaderPageObject;

public class Level_08_Register_Login_Dyamic_Locator extends BaseTest{
	WebDriver driver;
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	SearchPageObject searchPage;
	ShippingAndReturnPageObject shippingAndReturnPage;
	SiteMapPageObject siteMapPage;
	MyAccountFooterPageObject myAccountFooterPage;
	WishListHeaderPageObject wishListHeaderPage;
	
	String emailAddr, password; 
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//driver.get("https://demo.nopcommerce.com/");
		
		password = "123123";
		emailAddr = genEmail();
	}
	
	//@Test
	public void Login_01_Register_To_System() {

		//homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		//2 - Click to Register link
		registerPage = homePage.clickToRegisterLink();
		//registerPage = new RegisterPageObject(driver);
		
		//3 - Fill info to fields
		registerPage.clickToGenderMaileRadioButton();
		
		registerPage.inputToFirstNameTextbox("Hai");
		
		registerPage.inputToLastNameTextbox("Eagle");
		
		registerPage.inputToEmailTextbox(emailAddr);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		//4 - verify msg successfully
		Assert.assertTrue(registerPage.isSuccessRegisterMessageDisplayed());
		
		//5 - Logout & back Hompage
		homePage = registerPage.clickToLogout();
		//homePage = new HomePageObject(driver);
		
	}
	
	//@Test
	public void Login_02_Login_To_System() {
		// 1 - Click to Login link & forward to Login Page
		loginPage = homePage.clickToLoginLink();
		//loginPage = new LoginPageObject(driver);
		
		//2 - Input info to fields
		loginPage.inputToEmailTextbox(emailAddr);
		loginPage.inputToPasswordTextbox(password);
		
		//3 - click to Login button
		homePage = loginPage.clickToLoginButton();
		
		//4 - verify login successfully by back Homepage
		//homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
	}
	
	//@Test
	public void Login_03_Switch_Page() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		//Home Page -> Search Page
		searchPage = homePage.openSearchPage(driver);
		
		//Search Page > Shipping and Return Page
		shippingAndReturnPage = searchPage.openShippingAndReturnPage(driver);
		
		//Shipping and Return Page > Sitemap
		siteMapPage = shippingAndReturnPage.openSiteMapPage(driver);
		
		//Sitemap > Footer My Account Page
		myAccountFooterPage = siteMapPage.openMyAccountFooterPage(driver);
		
		//Footer My Account Page > Home Page
		homePage = myAccountFooterPage.openHomePage(driver);
		
		//Home Page > Header Wishlist
		wishListHeaderPage = homePage.openWishListHeader(driver);
		
		//Wishlist > Sitemap
		siteMapPage = wishListHeaderPage.openSiteMapPage(driver);
		
		//Sitemap > Search
		searchPage = siteMapPage.openSearchPage(driver);
		
		SleepInSecond(5);
		//Shipping and Return Page > Sitemap
		wishListHeaderPage = shippingAndReturnPage.openWishListHeader(driver);
		SleepInSecond(5);
		
	}
	
	@Test
	public void Login_04_Dynamic_Locator () {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Home Page -> Search Page
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		//Search Page > Shipping and Return Page
		searchPage.openFooterPageByName(driver, "Shipping & returns");
		shippingAndReturnPage = PageGeneratorManager.getShippingAndReturnPage(driver);
		
		//Shipping and Return Page > Sitemap
		shippingAndReturnPage.openFooterPageByName(driver, "Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		
		//Sitemap > Footer My Account Page
		siteMapPage.openFooterPageByName(driver, "My account");
		myAccountFooterPage = PageGeneratorManager.getMyAccountFooterPage(driver);
		
		//Footer My Account Page > Home Page
		homePage = myAccountFooterPage.openHomePage(driver);
		
		//Home Page > Header Wishlist
		homePage.openHeaderPageByName(driver, "Wishlist");
		wishListHeaderPage = PageGeneratorManager.getWishListHeaderPage(driver);
		
		//Wishlist > Sitemap
		wishListHeaderPage.openFooterPageByName(driver, "Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		
		//Sitemap > Search
		siteMapPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
	}
	
	@AfterClass

	public void quiteBrowser() {
		driver.quit();
		
	}
	
	public void SleepInSecond(long timeoutSecond) {
		try {
			Thread.sleep(timeoutSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
