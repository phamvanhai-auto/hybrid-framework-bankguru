package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.liveGuru.MyDashBoardPageUI;

public class MyDashBoardPageObject extends BasePage{
	private WebDriver driver;
	
	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getMyDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, MyDashBoardPageUI.MY_DASHBOARD_HEADER);
		return isElementDisplayed(driver, MyDashBoardPageUI.MY_DASHBOARD_HEADER);
	}
}
