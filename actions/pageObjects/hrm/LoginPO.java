package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.LoginUI;

public class LoginPO extends BasePage{
	private WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public DashboardPO loginToSystem(String userName, String password) {
		waitForElementVisible(driver, LoginUI.USER_NAME);
		sendKeyToElement(driver, LoginUI.USER_NAME, userName);
		
		waitForElementVisible(driver, LoginUI.PASSWORD);
		sendKeyToElement(driver, LoginUI.PASSWORD, password);
		
		waitForElementClickable(driver, LoginUI.LOGIN_BUTTON);
		clickToElement(driver, LoginUI.LOGIN_BUTTON);
		
		return PageGeneratorManager.getDashboardPage(driver);
	}
}
