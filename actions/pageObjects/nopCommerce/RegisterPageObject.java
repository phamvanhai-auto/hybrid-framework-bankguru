package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	//ham khoi tao (constructor)
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToGenderMaileRadioButton() {
		waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_BOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_BOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_BOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_BOX, lastName);
	}

	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_BOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_BOX, emailText);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_BOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_BOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONRFIRM_PASSWORD_BOX);
		sendKeyToElement(driver, RegisterPageUI.CONRFIRM_PASSWORD_BOX, password);
	}

	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessRegisterMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	public void clickToLogout() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}

}
