package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_BasePage_2 {
	WebDriver driver;
	BasePage basePage;
	
	String user, password, loginPageURL;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		//basePage = new BasePage();	
		basePage = BasePage.getBasePage();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		basePage.openUrl(driver, "http://demo.guru99.com/v4/");

		loginPageURL = basePage.getPageUrl(driver);
	}
	
	@Test
	public void Login_01_Register_To_System() {
		
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.sendKeyToElement(driver, "//input[@name='emailid']", genEmail());
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		
		user = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		basePage.openUrl(driver, loginPageURL);
		
		basePage.sendKeyToElement(driver, "//input[@name='uid']", user);
		basePage.sendKeyToElement(driver, "//input[@name='password']", password);
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
		
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
