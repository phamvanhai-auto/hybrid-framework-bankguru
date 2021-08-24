package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	//ham khoi tao
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Input to Email with value {0}")
	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_BOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_BOX, emailText);
	}

	@Step("Input to Password with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_BOX, password);
	}

	@Step("Click to Login button")
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
	}

}
