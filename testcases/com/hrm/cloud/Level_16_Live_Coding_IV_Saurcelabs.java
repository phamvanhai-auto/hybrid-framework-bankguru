package com.hrm.cloud;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.MyInfoPO;

public class Level_16_Live_Coding_IV_Saurcelabs extends BaseTest {
	WebDriver driver;

	LoginPO loginPage;
	DashboardPO dashBoardPage;
	EmployeeListPO employeeListPage;
	AddEmployeePO addEmployeePage;
	MyInfoPO myInfoPage;

	String employeeID, statusValue;
	String empfirstName, emplastName, empUserName, empPassword, fullName;
	String editEmpFirstName, editEmpLastName, editFullName, empGender, empMaritalStatus, empNationality;
	String empAddrStreet1, empCity, empProvince, empZip, empCountry, empHomeTel, empMobile;
	String emerContactName, emerRelationship, emerTelephone, emerMobile;
	String depenName, depenRelationship, depenDOB;
	String empCompany, empJobTitle, empFrom, empTo;

	String projectPath = System.getProperty("user.dir");
	String avatarFilePath = projectPath + "\\uploadFiles\\Avatar.jpg";
	String avaTarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "Avatar.jpg";

	@BeforeClass
	@Parameters({ "browser", "url", "osName" })
	public void initBrowser(String browserName, String urlPage, String osName) {

		log.info("Pre-condition - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsersSaucelabs(browserName, urlPage, osName);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Pre-condition - Step 02: Login to HRM Admin");
		dashBoardPage = loginPage.loginToSystem("Admin", "admin123");

		empfirstName = "Eagle";
		emplastName = "Pham";
		empUserName = "autofc";
		empPassword = "12345678";
		fullName = empfirstName + " " + emplastName;
		statusValue = "Enabled";

		editEmpFirstName = "Jason";
		editEmpLastName = "Satham";
		editFullName = editEmpFirstName + " " + editEmpLastName;
		empGender = "Male";
		empMaritalStatus = "Single";
		empNationality = "Vietnamese";

		empAddrStreet1 = "No.1 Springturn";
		empCity = "Sydney";
		empProvince = "New South Wales";
		empZip = "9899";
		empCountry = "Australia";
		empHomeTel = "+62 2389234883";
		empMobile = "02361 3423 23";

		emerContactName = "Martin";
		emerRelationship = "Brother";
		emerTelephone = "+62 38924323";
		emerMobile = "0632234934";

		depenName = "Eric";
		depenRelationship = "Child";
		depenDOB = "2019-09-16";

		empCompany = "Vinsmart";
		empJobTitle = "Senior QA";
		empFrom = "2019-09-16";
		empTo = "2021-06-16";
	}

	@Test
	public void Employee_01_Add_New_Employees() {

		log.info("01_Add_New - Step 01: Open 'Employee List' ");
		dashBoardPage.openSubMenuHeader(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("01_Add_New - Step 02: Click to 'Add' button ");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);

		log.info("01_Add_New - Step 03: Input valid info 'FirstName' textbox");
		addEmployeePage.inputToTextBoxByIDs(driver, "firstName", empfirstName);

		log.info("01_Add_New - Step 04: Input valid info 'LastName' textbox");
		addEmployeePage.inputToTextBoxByIDs(driver, "lastName", emplastName);

		log.info("01_Add_New - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getValueOfTextBoxByID(driver, "employeeId");
		System.out.println(employeeID);

		log.info("01_Add_New - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabelName(driver, "Create Login Details");

		log.info("01_Add_New - Step 07: Input valid info 'User Name'");
		addEmployeePage.inputToTextBoxByIDs(driver, "user_name", empUserName);

		log.info("01_Add_New - Step 08: Input valid info 'Password'");
		addEmployeePage.inputToTextBoxByIDs(driver, "user_password", empPassword);

		log.info("01_Add_New - Step 09: Input 'Confirm Password'");
		addEmployeePage.inputToTextBoxByIDs(driver, "re_password", empPassword);

		log.info("01_Add_New - Step 10: Select '" + statusValue + "' at 'Status' dropdown");
		addEmployeePage.selectItemDropdownByID(driver, "status", statusValue);

		log.info("01_Add_New - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);

		log.info("01_Add_New - Step 12: Back 'Employee List' ");
		myInfoPage.openSubMenuHeader(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("01_Add_New - Step 13: Input valid info to 'Employee Name' textbox ");
		employeeListPage.SleepInSecond(3);
		//verifyTrue(employeeListPage.isJQueryAndAjaxloadedSuccess(driver));
		employeeListPage.inputToTextBoxByIDs(driver, "empsearch_employee_name_empName", fullName);
		employeeListPage.SleepInSecond(3);
		//verifyTrue(employeeListPage.isJQueryAndAjaxloadedSuccess(driver));

		log.info("01_Add_New - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		// employeeListPage.SleepInSecond(3);
		verifyTrue(employeeListPage.isJQueryAndAjaxloadedSuccess(driver));

		log.info("01_Add_New - Step 15: Verify Employee Info at Result Table");
		// verifyTrue(employeeListPage.isEmployeeInfoDisplayedAtTable(employeeID, firstName, lastName));
		verifyEquals(employeeListPage.getValueOfTableAtColumnAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueOfTableAtColumnAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empfirstName);
		verifyEquals(employeeListPage.getValueOfTableAtColumnAndRowIndex(driver, "resultTable", "Last Name", "1"), emplastName);

	}

	@AfterClass
	public void quiteBrowser() {
		driver.quit();
	}

}
