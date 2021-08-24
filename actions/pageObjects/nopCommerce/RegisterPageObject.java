package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	//ham khoi tao (constructor)
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Gender Male radio")
	public void clickToGenderMaileRadioButton() {
		waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	@Step("Input to Firstname with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_BOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_BOX, firstName);
	}

	@Step("Input to Lastname with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_BOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_BOX, lastName);
	}

	@Step("Input to Email with value {0}")
	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_BOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_BOX, emailText);
		
	}

	@Step("Input to Password with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_BOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_BOX, password);
		
	}

	@Step("Input to Conf Pass with value {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONRFIRM_PASSWORD_BOX);
		sendKeyToElement(driver, RegisterPageUI.CONRFIRM_PASSWORD_BOX, password);
	}

	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Verify Reg message successfully displayed")
	public boolean isSuccessRegisterMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	@Step("Click to Logout")
	public HomePageObject clickToLogout() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
	}


}
