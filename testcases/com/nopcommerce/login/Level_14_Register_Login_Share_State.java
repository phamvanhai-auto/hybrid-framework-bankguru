package com.nopcommerce.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

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

public class Level_14_Register_Login_Share_State extends BaseTest {
	WebDriver driver;

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

	String emailAddr, password;

	@BeforeClass
	@Parameters({ "browser", "url" })
	public void initBrowser(String browserName, String urlPage) {

		log.info("Pre-conditon - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Login_02 - Step 01: Click Login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Login_02 - Step 02: Set login page cookie");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.SleepInSecond(3);
		loginPage.refreshPage(driver);
		
		log.info("Login_02 - Step 03: Verify Homepage displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_Register_02_To_System() {

	}

	@AfterClass
	public void quiteBrowser() {
		driver.quit();
	}

}
