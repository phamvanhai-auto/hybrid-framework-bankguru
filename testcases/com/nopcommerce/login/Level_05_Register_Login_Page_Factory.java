package com.nopcommerce.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Factory extends BaseTest{
	WebDriver driver;
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	String emailAddr, password; 
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//driver.get("https://demo.nopcommerce.com/");
		
		password = "123123";
		emailAddr = genEmail();
	}
	
	@Test
	public void Login_01_Register_To_System() {

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		//2 - Click to Register link
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
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
		registerPage.clickToLogout();
		homePage = new HomePageObject(driver);
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		// 1 - Click to Login link & forward to Login Page
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		//2 - Input info to fields
		loginPage.inputToEmailTextbox(emailAddr);
		loginPage.inputToPasswordTextbox(password);
		
		//3 - click to Login button
		loginPage.clickToLoginButton();
		
		//4 - verify login successfully by back Homepage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
	}
	
	@AfterClass
	public void quiteBrowser() {
		driver.quit();
		
	}
	
}
