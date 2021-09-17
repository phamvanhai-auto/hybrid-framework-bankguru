package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.DashboardUI;

public class DashboardPO extends BasePage{
	private WebDriver driver;
	
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

//	public EmployeeListPO openEmployeeList() {
//		waitForElementClickable(driver, DashboardUI.PIM_LINK);
//		hoverToElement(driver, DashboardUI.PIM_LINK);
//		
//		clickToElement(driver, DashboardUI.EMPLOYEE_LIST_LINK);
//		
//		return PageGeneratorManager.getEmployeeListPage(driver);
//	}
}
