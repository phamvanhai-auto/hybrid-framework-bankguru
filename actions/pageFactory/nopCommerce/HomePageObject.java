package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePageFactory{
	private WebDriver driver;
	
	//Page Factory
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className="ico-register")
	WebElement registerLink;
	
	@FindBy(className="ico-login")
	WebElement loginLink;
	
	
	//ham khoi tao
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
