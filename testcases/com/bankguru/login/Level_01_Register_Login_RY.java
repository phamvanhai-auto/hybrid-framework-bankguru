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

public class Level_01_Register_Login_RY {
	WebDriver driver;
	
	String user, password, loginPageURL;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.guru99.com/v4/");
		
		loginPageURL = driver.getCurrentUrl();
	}
	
	@Test
	public void Login_01_Register_To_System() {
		
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(genEmail());
		driver.findElement(By.name("btnLogin")).click();
		
		user = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		driver.get(loginPageURL);
		
		driver.findElement(By.name("uid")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		String welcomPage = driver.findElement(By.cssSelector("marquee.heading3")).getText();
		
		Assert.assertEquals(welcomPage, "Welcome To Manager's Page of Guru99 Bank");
		
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
