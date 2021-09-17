package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoUI;

public class MyInfoPO extends BasePage{
	private WebDriver driver;
	
	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeListPO openEmployeeList() {
		waitForElementClickable(driver, MyInfoUI.EMPLOYEE_LIST_LINK);
		clickToElement(driver, MyInfoUI.EMPLOYEE_LIST_LINK);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

	public void clickToChangeAvatar() {
		waitForElementVisible(driver, MyInfoUI.CHANGE_AVATAR);
		clickToElement(driver, MyInfoUI.CHANGE_AVATAR);
	}

	public void clickPictureToUpload(String filePath) {
		waitForElementVisible(driver, MyInfoUI.SELECT_PICTURE);
		sendKeyToElement(driver, MyInfoUI.SELECT_PICTURE, filePath);
	}

	public boolean isAvatarUploadSuccess() {
		waitForElementVisible(driver, MyInfoUI.AVATAR_IMG);
		int imgHeight = Integer.parseInt(getElementAttribute(driver, MyInfoUI.AVATAR_IMG, "height"));
		int imgWidth = Integer.parseInt(getElementAttribute(driver, MyInfoUI.AVATAR_IMG, "width"));
		
		return (imgHeight != 200) || (imgWidth != 200);
	}

	
	public void openItemsAtSidebarByName(String itemName) {
		waitForElementVisible(driver, MyInfoUI.ITEMS_AT_SIDEBAR_BY_NAME, itemName);
		clickToElement(driver, MyInfoUI.ITEMS_AT_SIDEBAR_BY_NAME, itemName);
	}
}
