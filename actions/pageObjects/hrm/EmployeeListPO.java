package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.EmployeeListUI;

public class EmployeeListPO extends BasePage{
	private WebDriver driver;
	
	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

	public AddEmployeePO clickToAddButton() {
		waitForElementClickable(driver, EmployeeListUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListUI.ADD_BUTTON);
		return PageGeneratorManager.getAddEmployeePage(driver);
	}

	public void inputToEmployeeNameTextbox(String employeeName) {
		waitForElementVisible(driver, EmployeeListUI.EMPLOYEE_NAME_TEXTBOX);
		sendKeyToElement(driver, EmployeeListUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, EmployeeListUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListUI.SEARCH_BUTTON);
	}

	public boolean isEmployeeInfoDisplayedAtTable(String employeeID, String firstName, String lastName) {
		waitForElementVisible(driver, EmployeeListUI.EMPLOYEE_INFO_TABLE, employeeID, firstName, lastName);
		return isElementDisplayed(driver, EmployeeListUI.EMPLOYEE_INFO_TABLE, employeeID, firstName, lastName);
		
	}
}
