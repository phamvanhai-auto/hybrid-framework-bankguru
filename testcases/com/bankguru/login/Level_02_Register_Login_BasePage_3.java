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

public class Level_02_Register_Login_BasePage_3 extends BasePage {
	WebDriver driver;
	//BasePage basePage;
	
	String user, password, loginPageURL;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		//basePage = new BasePage();	
		//basePage = getBasePage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		openUrl(driver, "http://demo.guru99.com/v4/");
		loginPageURL = getPageUrl(driver);
	}
	
	@Test
	public void Login_01_Register_To_System() {
		
		clickToElement(driver, "//a[text()='here']");
		sendKeyToElement(driver, "//input[@name='emailid']", genEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		
		user = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		openUrl(driver, loginPageURL);
		
		sendKeyToElement(driver, "//input[@name='uid']", user);
		sendKeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
		
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
