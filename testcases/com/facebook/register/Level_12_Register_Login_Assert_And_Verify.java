package com.facebook.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


public class Level_12_Register_Login_Assert_And_Verify extends BaseTest{
	WebDriver driver;

	HomePageObject homePage;
	RegisterPageObject registerPage;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.createNewAccount();
		
	}
	
	@Test
	public void TC_01_Register_Element_Displayed() {
		//Fail lan 1
		verifyFalse(registerPage.isEmailTextBoxDisplayed());	

		verifyFalse(registerPage.isConfirmEmailTextBoxDisplayed());

		//Fail lan 2
		verifyTrue(registerPage.isLoginButtonDisplayed());

		verifyTrue(registerPage.isLoginButtonUndisplayed());
	}


	@AfterClass

	public void quiteBrowser() {
		driver.quit();
		
	}
	
}
