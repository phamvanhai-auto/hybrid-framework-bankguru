package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextBoxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXT_BOX);
	}

	public boolean isConfirmEmailTextBoxDisplayed() {

		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXT_BOX);
	}

	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUndisplayed() {
		waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

}
