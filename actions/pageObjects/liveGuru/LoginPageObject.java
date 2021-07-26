package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String emailAddr) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, emailAddr);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	}

	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public String getIncorrectEmailOrPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INCORRECT_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}

}
