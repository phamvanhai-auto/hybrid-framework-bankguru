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


public class Level_11_Register_Login_Element_Undisplayed extends BaseTest{
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
		//wait & displayed: Visible on UI + Exist on DOM
		Assert.assertTrue(registerPage.isEmailTextBoxDisplayed());
		
	}
		
	@Test
	public void TC_02_Register_Element_Undisplayed_And_In_DOM() {
		//Invisible on UI + Exist on DOM
		
		Assert.assertFalse(registerPage.isConfirmEmailTextBoxDisplayed());
	}
	
	
	@Test
	public void TC_03_Register_Element_Undisplayed_And_Not_In_DOM() {
		//Invisible on UI + Not on DOM
		//isDisplayed k the tra lai true/false vi no da bi false o buoc findElement (k co trong DOM)
		//Giai phap dung try-catch
		//nhuoc diem wait het timeout cua implicit/explicit
		
		//Phu dinh
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		
	}
	
	
	@Test
	public void TC_04_Register_Element_Undisplayed_And_Not_In_DOM() {
		//giai phap cho TC_03 (k pai doi het timeout)
		//override lai timeout sau moi lan findelement
		
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
		
	}

	@AfterClass

	public void quiteBrowser() {
		driver.quit();
		
	}
	
}
