package com.nopcommerce.admin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.admin.DashboardPO;
import pageObjects.nopCommerce.admin.LoginPO;
import pageObjects.nopCommerce.admin.PageGeneratorManager;
import pageObjects.nopCommerce.admin.ProductDetailPO;
import pageObjects.nopCommerce.admin.ProductSearchPO;

public class Level_10_Upload_Files_Apply_To_FW extends BaseTest{
	WebDriver driver;
	
	LoginPO loginPage;
	DashboardPO dashboardPage;
	ProductSearchPO productSearchPage;
	ProductDetailPO productDetailPage;
	
	String productName = "Apple MacBook Pro 13-inch";
	String avatarPicture = "Avatar.jpg";
	String altText = "Alt";
	String titleText = "Title";
	String orderNumber = "0";
	
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initBrowser(String browserName, String urlPage) {
		
		driver = openMultipleBrowsers(browserName, urlPage);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.inputEmailBox("admin@yourstore.com");
		loginPage.inputPasswordBox("admin");
		dashboardPage = loginPage.clickLoginButton();
		
		dashboardPage.openSubMenuByName(driver, "Catalog", "Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
	}
	
	@Test
	public void Upload_01_Product() {
		
		productSearchPage.inputToSearchProduct(productName);
		productSearchPage.clickSearchButton();
		
		productDetailPage = productSearchPage.clickEditButtonByProductName(productName);
		
		productDetailPage.clickToExpandPanelByName("Pictures");
		
		productDetailPage.uploadFilesByCardName(driver, "pictures", avatarPicture);
		
		Assert.assertTrue(productDetailPage.isPictureUploadDisplayedByFileName(avatarPicture));
		
		productDetailPage.inputToAltBox(altText);
		productDetailPage.inputToTitleBox(titleText);
		//productDetailPage.inputToDisplayOrderBox("0");
		
		productDetailPage.clickToAddProductPictureButton();
		
		Assert.assertTrue(productDetailPage.isPictureAndValueUpdated(productName, orderNumber, altText, titleText));
		
		productSearchPage = productDetailPage.clickToSaveButton();
		
		Assert.assertTrue(productSearchPage.isSucessMessageDisplayed("The product has been updated successfully."));
		
		productSearchPage.inputToSearchProduct(productName);
		productSearchPage.clickSearchButton();
		
		Assert.assertTrue(productSearchPage.isPictureAndProductNameDisplayed(productName, productName));
		
		productDetailPage = productSearchPage.clickEditButtonByProductName(productName);
		
		productDetailPage.clickToExpandPanelByName("Pictures");
		
		productDetailPage.clickToDeleteButtonByPictureName(titleText, "Delete"); //define accept alert
		
		Assert.assertFalse(productDetailPage.isPictureAndValueUpdated(productName, orderNumber, altText, titleText)); //k còn ảnh đó nữa
		
		productSearchPage = productDetailPage.clickToSaveButton();
		Assert.assertTrue(productSearchPage.isSucessMessageDisplayed("The product has been updated successfully."));
		
		productSearchPage.inputToSearchProduct(productName);
		productSearchPage.clickSearchButton();
		
	}


	
	@AfterClass

	public void quiteBrowser() {
		driver.quit();
		
	}
	
	
}
