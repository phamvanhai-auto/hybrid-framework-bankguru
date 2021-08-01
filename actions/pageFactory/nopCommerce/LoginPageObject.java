package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory{
	private WebDriver driver;
	
	//Define Element
	@FindBy(id="Email")
	WebElement emailBox;
	
	@FindBy(id="Password")
	WebElement passwordBox;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement loginButton;
	
	//ham khoi tao
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToEmailTextbox(String emailText) {
		waitForElementVisible(driver, emailBox);
		sendKeyToElement(driver, emailBox, emailText);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordBox);
		sendKeyToElement(driver, passwordBox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
