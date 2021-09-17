package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.AddEmployeeUI;
import pageUIs.nopCommerce.admin.AdminBasePageUIs;

public class AddEmployeePO extends BasePage{
	private WebDriver driver;
	
	public AddEmployeePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddEmployeeUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeeUI.FIRST_NAME_TEXTBOX, firstName);
	
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddEmployeeUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeeUI.LAST_NAME_TEXTBOX, lastName);		
	}

	public String getValueOfEmployeeID(String value) {
		waitForElementVisible(driver, AddEmployeeUI.EMPLOYEE_ID);
		return getElementAttribute(driver, AddEmployeeUI.EMPLOYEE_ID, value);
	}

	public void clickToCreateLoginDetailsCheckbox() {
		waitForElementVisible(driver, AddEmployeeUI.CREATE_LOGIN_DETAILS_CHECKBOX);
		clickToElement(driver, AddEmployeeUI.CREATE_LOGIN_DETAILS_CHECKBOX);
	}

	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, AddEmployeeUI.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeeUI.USER_NAME_TEXTBOX, userName);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeeUI.PASSWROD_TEXTBOX);
		sendKeyToElement(driver, AddEmployeeUI.PASSWROD_TEXTBOX, password);		
	}

	public void inputToConfPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeeUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AddEmployeeUI.CONFIRM_PASSWORD_TEXTBOX, password);				
	}

	public void selectValueInStatusDropdown(String statusValue) {
		waitForElementVisible(driver, AddEmployeeUI.STATUS_DROPDOWN);
		selectItemInDropdownByText(driver, AddEmployeeUI.STATUS_DROPDOWN, statusValue);
	}

	public MyInfoPO clickToSaveButton() {
		waitForElementClickable(driver, AddEmployeeUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeeUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyInfoPage(driver);
	}
}
