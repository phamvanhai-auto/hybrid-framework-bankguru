package com.nopcommerce.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;


public class Level_15_Register_Login_Pattern_Object extends BaseTest {
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// driver.get("https://demo.nopcommerce.com/");

		password = "123123";
		emailAddr = genEmail();
	}

	@Test
	public void Login_Register_01_To_System() {

		log.info("Register_01 - Step 01: Verify Homepage displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("Register_01 - Step 02: Click to Register Link");
		homePage.openHeaderPageByLinkName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register_01 - Step 03: Click to Male button");
		registerPage.clickToRadioButtonByName(driver, "Male");

		log.info("Register_01 - Step 04: Input FirstName/LastName");		
		registerPage.inputToTextBoxByID(driver, "FirstName", "Hai");
		registerPage.inputToTextBoxByID(driver, "LastName", "Eagle");
		
		log.info("Register_01 - Step 04.1: Input Date/Month/Year info");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "7");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", "November");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", "1991");
		registerPage.SleepInSecond(3);

		log.info("Register_01 - Step 05: Input 'Email' textbox " + emailAddr);
		registerPage.inputToTextBoxByID(driver, "Email", emailAddr);

		log.info("Register_01 - Step 06: Input 'Password' textbox " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);

		log.info("Register_01 - Step 07: Click Register button");
		registerPage.clickToButtonByName(driver, "Register");

		log.info("Register_01 - Step 08: Verify Successfully message");
		verifyTrue(registerPage.isSuccessRegisterMessageDisplayed());

		log.info("Register_01 - Step 09: Click Logout");
		registerPage.openHeaderPageByLinkName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Login_Register_02_To_System() {
		log.info("Login_02 - Step 01: Click Login link");
		homePage.openHeaderPageByLinkName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Login_02 - Step 02: Input 'Email' " + emailAddr);
		loginPage.inputToTextBoxByID(driver, "Email", emailAddr);

		log.info("Login_02 - Step 03: Input 'Password' " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);

		log.info("Login_02 - Step 04: Click to Login button");
		loginPage.clickToButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Login_02 - Step 05: Verify Homepage displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void quiteBrowser() {
		driver.quit();
	}

	public void SleepInSecond(long timeoutSecond) {
		try {
			Thread.sleep(timeoutSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
