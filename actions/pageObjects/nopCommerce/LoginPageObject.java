package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	//ham khoi tao
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_BOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_BOX, emailText);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_BOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
