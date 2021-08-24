package com.nopcommerce.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountFooterPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.ShippingAndReturnPageObject;
import pageObjects.nopCommerce.SiteMapPageObject;
import pageObjects.nopCommerce.WishListHeaderPageObject;

@Epic("Web")
@Feature("User")
public class Level_13_Register_Login_Log_AllureReport extends BaseTest{
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
		
		log.info("Pre-conditon - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//driver.get("https://demo.nopcommerce.com/");
		
		password = "123123";
		emailAddr = genEmail();
		//Assert.assertTrue(false);
	
	}
	
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Description("Register to System & verify successfylly")
	@Test
	public void Login_Register_01_To_System() {

		log.info("Register_01 - Step 01: Verify Homepage displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Register_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_01 - Step 03: Click to Male button");
		registerPage.clickToGenderMaileRadioButton();
		
		log.info("Register_01 - Step 04: Input FirstName/LastName");
		registerPage.inputToFirstNameTextbox("Hai");
		registerPage.inputToLastNameTextbox("Eagle");
		
		log.info("Register_01 - Step 05: Input 'Email' textbox "  + emailAddr);
		registerPage.inputToEmailTextbox(emailAddr);
		
		log.info("Register_01 - Step 06: Input 'Password' textbox "  + password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register_01 - Step 07: Click Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_01 - Step 08: Verify Successfully message");
		verifyTrue(registerPage.isSuccessRegisterMessageDisplayed());
		
		log.info("Register_01 - Step 09: Click Logout");
		homePage = registerPage.clickToLogout();
		
	}
	
	@Story("Login")
	@Severity(SeverityLevel.NORMAL)
	@Description("Login to System & verify successfylly")
	@Test
	public void Login_Register_02_To_System() {
		log.info("Login_02 - Step 01: Click Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login_02 - Step 02: Input 'Email' "  + emailAddr);
		loginPage.inputToEmailTextbox(emailAddr);
		
		log.info("Login_02 - Step 03: Input 'Password' "  + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login_02 - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login_02 - Step 05: Verify Homepage displayed");
		verifyFalse(homePage.isHomePageSliderDisplayed());
		
	}
		
	@AfterClass(alwaysRun = true)
	public void quiteBrowser() {
		closeBrowserAndDriver();
		//driver.quit();
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
