package com.jquery.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;


public class Level_09_JQuery_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	
	//@Test
	public void Table_01_Paging_By_Number() {
		homePage.openPageByNumber("3");
		Assert.assertTrue(homePage.isPageOpenedByNumber("3"));
		
		homePage.openPageByNumber("13");
		Assert.assertTrue(homePage.isPageOpenedByNumber("13"));
				
		homePage.openPageByNumber("9");
		Assert.assertTrue(homePage.isPageOpenedByNumber("9"));
	}
	
	//@Test
	public void Table_02_Search_Data_By_Input() {
		//Input to Textbox
		homePage.inputToHeaderBoxByColumnName("Females", "8219");
		homePage.SleepInSecond(2);
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderBoxByColumnName("Country", "Afghanistan");
		homePage.SleepInSecond(5);
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderBoxByColumnName("Total", "14584");
		homePage.SleepInSecond(2);
		homePage.refreshPage(driver);

	}
	
	//@Test
	public void Table_03_Delete_Edit_Row() {
		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.SleepInSecond(2);
		
		homePage.clickToIconByCountryName("Albania", "edit");
		homePage.SleepInSecond(2);
		homePage.refreshPage(driver);
		
		homePage.clickToIconByCountryName("	Angola", "remove");
		homePage.SleepInSecond(2);
	}
		
	//@Test
	public void Table_04_Verify_Row_Data() {
		homePage.inputToHeaderBoxByColumnName("Country", "Afghanistan");
		homePage.SleepInSecond(2);
		Assert.assertTrue(homePage.isRowValueCorrect("384187", "Afghanistan", "407124", "791312"));
		
	}
	
	//@Test
	public void Table_05_Input_To_Row_TextBox() {
		homePage.inputToRowBoxByIndex("Contact Person", "3", "Auto FC");
		homePage.SleepInSecond(2);
		
		homePage.inputToRowBoxByIndex("Order Placed", "1", "3");
		homePage.SleepInSecond(2);
		
	}
	
	@Test
	public void Table_05_Click_To_Buttons() {
		//input data to rows
		homePage.inputToRowBoxByIndex("Company", "1", "Row 1");
		homePage.inputToRowBoxByIndex("Company", "2", "Row 2");
		homePage.inputToRowBoxByIndex("Company", "3", "Row 3");
		
		homePage.clickToButtonByRowNumber("2", "Insert Row Above");
		homePage.SleepInSecond(2);
		
		homePage.clickToButtonByRowNumber("4", "Move Up");
		homePage.SleepInSecond(2);
		
		homePage.clickToButtonByRowNumber("3", "Remove Current Row");
		homePage.SleepInSecond(2);
	}
	
	@AfterClass

	public void quiteBrowser() {
		driver.quit();
		
	}
	
}
