package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	
	//Define Elements	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement genderMaleRadio;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstNameBox;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastNameBox;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordBox;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordBox;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement successRegisterMessage;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logoutLink;
	
	//ham khoi tao (constructor)
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToGenderMaileRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameBox);
		sendKeyToElement(driver, firstNameBox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameBox);
		sendKeyToElement(driver, lastNameBox, lastName);
	}

	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, emailBox);
		sendKeyToElement(driver, emailBox, emailText);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordBox);
		sendKeyToElement(driver, passwordBox, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, confirmPasswordBox);
		sendKeyToElement(driver, confirmPasswordBox, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public boolean isSuccessRegisterMessageDisplayed() {
		waitForElementVisible(driver, successRegisterMessage);
		return isElementDisplayed(driver, successRegisterMessage);
	}

	public void clickToLogout() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
