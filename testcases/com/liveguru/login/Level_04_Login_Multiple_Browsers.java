package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;

public class Level_04_Login_Multiple_Browsers extends BaseTest{
	WebDriver driver;

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashBoardPage;

	String emailAddr, password;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver.get("http://live.demoguru99.com/");
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		// Home Page
		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("");
		loginPage.inputToPasswordTextBox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void Login_02_Login_Invalid_Email() {
		loginPage.refreshPage(driver);

		loginPage.inputToEmailTextBox("123@132.12");
		loginPage.inputToPasswordTextBox("123123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void Login_03_Login_Invalid_Password() {
		loginPage.refreshPage(driver);

		loginPage.inputToEmailTextBox("auto112@mail.com");
		loginPage.inputToPasswordTextBox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void Login_04_Login_Incorrect_Email() {
		loginPage.refreshPage(driver);

		loginPage.inputToEmailTextBox(genEmail());
		loginPage.inputToPasswordTextBox("123123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_05_Login_Incorrect_Password() {
		loginPage.refreshPage(driver);

		loginPage.inputToEmailTextBox("haimai@gmail.com");
		loginPage.inputToPasswordTextBox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Login_Valid_Email_Password() {
		loginPage.refreshPage(driver);

		loginPage.inputToEmailTextBox("haimai@gmail.com");
		loginPage.inputToPasswordTextBox("123123");
		loginPage.clickToLoginButton();

		// Login Page -> MyDashBoard page
		myDashBoardPage = new MyDashBoardPageObject(driver);
		Assert.assertTrue(myDashBoardPage.getMyDashBoardHeaderDisplayed());
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
