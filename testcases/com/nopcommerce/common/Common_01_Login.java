package com.nopcommerce.common;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;


public class Common_01_Login extends BaseTest{
	WebDriver driver;
	public static Set<Cookie> loginPageCookie;
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	
	String emailAddr, password; 
	
	@BeforeTest
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		log.info("Pre-conditon - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		//driver.get("https://demo.nopcommerce.com/");
		
		password = "123123";
		emailAddr = genEmail();

		log.info("Common_01 - Step 01: Verify Homepage displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Common_01 - Step 03: Click to Male button");
		registerPage.clickToGenderMaileRadioButton();
		
		log.info("Common_01 - Step 04: Input FirstName/LastName");
		registerPage.inputToFirstNameTextbox("Hai");
		registerPage.inputToLastNameTextbox("Eagle");
		
		log.info("Common_01 - Step 05: Input 'Email' textbox "  + emailAddr);
		registerPage.inputToEmailTextbox(emailAddr);
		
		log.info("Common_01 - Step 06: Input 'Password' textbox "  + password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Common_01 - Step 07: Click Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 08: Verify Successfully message");
		verifyTrue(registerPage.isSuccessRegisterMessageDisplayed());
		
		log.info("Common_01 - Step 09: Click Logout");
		homePage = registerPage.clickToLogout();
		
		log.info("Common_01 - Step 10: Click Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Common_01 - Step 11: Input 'Email' "  + emailAddr);
		loginPage.inputToEmailTextbox(emailAddr);
		
		log.info("Common_01 - Step 12: Input 'Password' "  + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Common_01 - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 14: Verify Homepage displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 15 : Get all login page cookies"); 
		loginPageCookie = homePage.getAllCookies(driver);
		
		//driver.quit();
		closeBrowserAndDriver();
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
