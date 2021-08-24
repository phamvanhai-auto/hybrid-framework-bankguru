package com.nopcommerce.login;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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
import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_Log_ExtentReportV2 extends BaseTest{
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
		
		//ExtentTestManager.getTest().log(LogStatus.INFO, "Pre-conditon - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//driver.get("https://demo.nopcommerce.com/");
		
		password = "123123";
		emailAddr = genEmail();
	}
	
	@Test
	public void Login_Register_01_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_Register_01_To_System");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 01: Verify Homepage displayed");	
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 03: Click to Male button");
		registerPage.clickToGenderMaileRadioButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 04: Input FirstName/LastName");
		registerPage.inputToFirstNameTextbox("Hai");
		registerPage.inputToLastNameTextbox("Eagle");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 05: Input 'Email' textbox "  + emailAddr);
		registerPage.inputToEmailTextbox(emailAddr);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 06: Input 'Password' textbox "  + password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 07: Click Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 08: Verify Successfully message");
		verifyTrue(registerPage.isSuccessRegisterMessageDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register_01 - Step 09: Click Logout");
		homePage = registerPage.clickToLogout();
		
		ExtentTestManager.endTest();
	}
	
	@Test
	public void Login_Register_02_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_Register_02_To_System");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02 - Step 01: Click Login link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02 - Step 02: Input 'Email' "  + emailAddr);
		loginPage.inputToEmailTextbox(emailAddr);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02 - Step 03: Input 'Password' "  + password);
		loginPage.inputToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02 - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02 - Step 05: Verify Homepage displayed");
		verifyFalse(homePage.isHomePageSliderDisplayed());
		
		ExtentTestManager.endTest();
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
