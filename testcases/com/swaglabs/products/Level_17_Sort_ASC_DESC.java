package com.swaglabs.products;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.swaglabs.LoginPO;
import pageObjects.swaglabs.PageGeneratorManager;
import pageObjects.swaglabs.ProductsPO;

public class Level_17_Sort_ASC_DESC extends BaseTest {
	WebDriver driver;

	LoginPO loginPage;
	ProductsPO productsPage;
	
	@BeforeClass
	@Parameters({ "browser", "url" })
	public void initBrowser(String browserName, String urlPage) {

		log.info("Pre-condition - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Pre-condition - Step 02: Login to Products page");
		productsPage = loginPage.loginToSystem("standard_user", "secret_sauce");

	}

	@Test
	public void Sort_01_Product_Name() {

		productsPage.selectItemInSortDropdown("Name (A to Z)");
		productsPage.SleepInSecond(3);
		verifyTrue(productsPage.isProductNameSortAscending());
		
		productsPage.selectItemInSortDropdown("Name (Z to A)");
		productsPage.SleepInSecond(3);
		verifyTrue(productsPage.isProductNameSortDescending());
	}
	
	@Test
	public void Sort_02_Product_Price() {
		productsPage.selectItemInSortDropdown("Price (low to high)");
		productsPage.SleepInSecond(3);
		verifyTrue(productsPage.isProductPriceSortAscending());
		
		productsPage.selectItemInSortDropdown("Price (high to low)");
		productsPage.SleepInSecond(3);
		verifyTrue(productsPage.isProductPriceSortDesending());
	}

	
	@AfterClass
	public void quiteBrowser() {
		driver.quit();
	}

}
