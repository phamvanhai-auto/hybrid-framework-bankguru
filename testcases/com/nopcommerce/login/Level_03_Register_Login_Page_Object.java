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

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

	String emailAddr, password;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser(String browserName) {

		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		password = "123123";
		emailAddr = genEmail();
	}

	@Test
	public void Login_01_Register_To_System() {
		// 1 - Open url & verify HomePage displayed
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		// 2 - Click to Register link
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		// 3 - Fill info to fields
		registerPage.clickToGenderMaileRadioButton();

		registerPage.inputToFirstNameTextbox("Hai");

		registerPage.inputToLastNameTextbox("Eagle");

		registerPage.inputToEmailTextbox(emailAddr);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		// 4 - verify msg successfully
		Assert.assertTrue(registerPage.isSuccessRegisterMessageDisplayed());

		// 5 - Logout & back Hompage
		registerPage.clickToLogout();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_02_Login_To_System() {
		// 1 - Click to Login link & forward to Login Page
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		// 2 - Input info to fields
		loginPage.inputToEmailTextbox(emailAddr);
		loginPage.inputToPasswordTextbox(password);

		// 3 - click to Login button
		loginPage.clickToLoginButton();

		// 4 - verify login successfully by back Homepage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void quiteBrowser() {
		driver.quit();

	}

	public String genEmail() {
		Random rand = new Random();
		return "autofc" + rand.nextInt(9999) + "@mail.com";

	}
}
