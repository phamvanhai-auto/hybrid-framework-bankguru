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

public class Level_16_Live_Coding_I extends BaseTest {
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
	@Parameters({ "browser", "url" })
	public void initBrowser(String browserName, String urlPage) {

		log.info("Pre-condition - Step 01: Open browser  " + browserName + " with " + urlPage + " ");
		driver = openMultipleBrowsers(browserName, urlPage);
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

	// @Test
	public void Employee_01_Add_New_Employee() {

		log.info("01_Add_New - Step 01: Open 'Employee List' ");
		dashBoardPage.openSubMenuHeader(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("01_Add_New - Step 02: Click to 'Add' button ");
		addEmployeePage = employeeListPage.clickToAddButton();

		log.info("01_Add_New - Step 03: Input valid info 'FirstName' textbox");
		addEmployeePage.inputToFirstNameTextbox(empfirstName);

		log.info("01_Add_New - Step 04: Input valid info 'LastName' textbox");
		addEmployeePage.inputToLastNameTextbox(emplastName);

		log.info("01_Add_New - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getValueOfEmployeeID("value");

		log.info("01_Add_New - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCreateLoginDetailsCheckbox();

		log.info("01_Add_New - Step 07: Input valid info 'User Name'");
		addEmployeePage.inputToUserNameTextbox(empUserName);

		log.info("01_Add_New - Step 08: Input valid info 'Password'");
		addEmployeePage.inputToPasswordTextbox(empPassword);

		log.info("01_Add_New - Step 09: Input 'Confirm Password'");
		addEmployeePage.inputToConfPasswordTextbox(empPassword);

		log.info("01_Add_New - Step 10: Select '" + statusValue + "' at 'Status' dropdown");
		addEmployeePage.selectValueInStatusDropdown(statusValue);

		log.info("01_Add_New - Step 11: Click to 'Save' button");
		myInfoPage = addEmployeePage.clickToSaveButton();

		log.info("01_Add_New - Step 12: Back 'Employee List' ");
		myInfoPage.openSubMenuHeader(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("01_Add_New - Step 13: Input valid info to 'Employee Name' textbox ");
		employeeListPage.inputToEmployeeNameTextbox(empfirstName + " " + emplastName);

		log.info("01_Add_New - Step 14: Click to 'Search' button");
		employeeListPage.clickToSearchButton();

		log.info("01_Add_New - Step 15: Verify Employee Info at Result Table");
		verifyTrue(employeeListPage.isEmployeeInfoDisplayedAtTable(employeeID, empfirstName, emplastName));

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

//	@Test
	public void Employee_02_Upload_Avatar() {
		employeeListPage.clickToItemValueOfTableAtColumnAndRowIndex(driver, "resultTable", "Id", "1");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);
		myInfoPage.clickToChangeAvatar();

		myInfoPage.clickPictureToUpload(avatarFilePath);
		myInfoPage.clickToButtonByID(driver, "btnSave");
	}

	@Test
	public void Employee_02_Upload_Avatars() {
		log.info("02_Upload_Avatar - Step 01: Logout system");
		loginPage = employeeListPage.logoutToSystem(driver);

		log.info("02_Upload_Avatar - Step 02: Login to system by User acc");
		loginPage.loginToSystem(empUserName, empPassword);
		dashBoardPage = PageGeneratorManager.getDashboardPage(driver);

		log.info("02_Upload_Avatar - Step 03: Open Personal details page");
		dashBoardPage.openMenuHeader(driver, "My Info");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);

		log.info("02_Upload_Avatar - Step 04: Click change photo");
		myInfoPage.clickToChangeAvatar();

		log.info("02_Upload_Avatar - Step 05: Upload new photo ");
		myInfoPage.clickPictureToUpload(avatarFilePath);

		log.info("02_Upload_Avatar - Step 06: Click to Upload button");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("02_Upload_Avatar - Step 07: Verify upload message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Uploaded"));

		log.info("02_Upload_Avatar - Step 08: Verify Avatar upload successfully");
		verifyTrue(myInfoPage.isAvatarUploadSuccess());
	}

	@Test
	public void Employee_03_Personal_Details() {
		log.info("03_Personal_Details - Step 01: Open 'Personal Details' at Sidebar");
		myInfoPage.openItemsAtSidebarByName("Personal Details");

		log.info("03_Personal_Details - Step 02: Verify all fields at 'Personal Details' form is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtLicExpDate"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_DOB"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_chkSmokeFlag"));

		log.info("03_Personal_Details - Step 02: Click to 'Edit' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("03_Personal_Details - Step 02: After clicked 'Edit', verify fields is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_DOB"));

		log.info("03_Personal_Details - Step 03: Input new value to 'FirstName' textbox");
		myInfoPage.inputToTextBoxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);

		log.info("03_Personal_Details - Step 03: Input new value to 'LastName' textbox");
		myInfoPage.inputToTextBoxByID(driver, "personal_txtEmpLastName", editEmpLastName);

		log.info("03_Personal_Details - Step 03: Select new value to 'Gender' radio");
		myInfoPage.clickToRadioButtonByName(driver, empGender);

		log.info("03_Personal_Details - Step 03: Select new value to 'Marital Status' dropdown");
		myInfoPage.selectItemDropdownByID(driver, "personal_cmbMarital", empMaritalStatus);

		log.info("03_Personal_Details - Step 03: Select new value to 'Nationality' dropdown");
		myInfoPage.selectItemDropdownByID(driver, "personal_cmbNation", empNationality);

		log.info("03_Personal_Details - Step 03: Click to 'Smoker'checkbox");
		myInfoPage.clickToCheckboxByLabelName(driver, "Smoker");

		log.info("03_Personal_Details - Step 03: Click to 'Save' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("03_Personal_Details - Step 03: Verify success message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Saved"));

		log.info("03_Personal_Details - Step 03: Verify 'FirstName' textbox updated success");
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);

		log.info("03_Personal_Details - Step 03: Verify 'LastName' textbox updated success");
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "personal_txtEmpLastName"), editEmpLastName);

		log.info("03_Personal_Details - Step 03: Verify 'Employee ID' value textbox ");
		// verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "personal_txtEmployeeId"), employeeID);

		log.info("03_Personal_Details - Step 03: Verify 'Gender' radio updated success");
		verifyTrue(myInfoPage.isRaidoSelectedByLabel(driver, empGender));

		log.info("03_Personal_Details - Step 03: Verify 'Marital Status' dropdown updated success");
		verifyEquals(myInfoPage.getSelectedItemDropdownByID(driver, "personal_cmbMarital"), empMaritalStatus);

		log.info("03_Personal_Details - Step 03: Verify 'Nationality' dropdown updated success");
		verifyEquals(myInfoPage.getSelectedItemDropdownByID(driver, "personal_cmbNation"), empNationality);

		log.info("03_Personal_Details - Step 03: Verify 'Smoker' radio updated success");
		verifyTrue(myInfoPage.isCheckboxCheckedByLabel(driver, "Smoker"));

	}

	@Test
	public void Employee_04_Contact_Details() {
		log.info("04_Contact_Details - Step 01: Open 'Contact Details' at Sidebar");
		myInfoPage.openItemsAtSidebarByName("Contact Details");

		log.info("04_Contact_Details - Step 02: Verify all field at 'Contact Details' disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_province"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_work_telephone"));

		log.info("04_Contact_Details - Step 03: Click to 'Edit' button at 'Contact Details'");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("04_Contact_Details - Step 04: Input new value to fields at 'Contact Details'");
		myInfoPage.inputToTextBoxByID(driver, "contact_street1", empAddrStreet1);
		myInfoPage.inputToTextBoxByID(driver, "contact_city", empCity);
		myInfoPage.inputToTextBoxByID(driver, "contact_province", empProvince);
		myInfoPage.inputToTextBoxByID(driver, "contact_emp_zipcode", empZip);
		myInfoPage.selectItemDropdownByID(driver, "contact_country", empCountry);
		myInfoPage.inputToTextBoxByID(driver, "contact_emp_hm_telephone", empHomeTel);
		myInfoPage.inputToTextBoxByID(driver, "contact_emp_mobile", empMobile);

		log.info("04_Contact_Details - Step 05: Click to 'Save' button at 'Contact Details'");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("04_Contact_Details - Step 06: Verify success message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Saved"));

		log.info("04_Contact_Details - Step 07: Verify value of field after edit at 'Contact Details'");
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_street1"), empAddrStreet1);
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_city"), empCity);
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_province"), empProvince);
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_emp_zipcode"), empZip);
		verifyEquals(myInfoPage.getSelectedItemDropdownByID(driver, "contact_country"), empCountry);
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_emp_hm_telephone"), empHomeTel);
		verifyEquals(myInfoPage.getValueOfTextBoxByID(driver, "contact_emp_mobile"), empMobile);

	}

	@Test
	public void Employee_05_Emergency_Contact() {
		log.info("05_Emergency_Contact - Step 01: Open 'Emergency Contacts' at Sidebar'");
		myInfoPage.openItemsAtSidebarByName("Emergency Contacts");

		log.info("05_Emergency_Contact - Step 02: Click to 'Add' button ");
		myInfoPage.clickToButtonByID(driver, "btnAddContact");

		log.info("05_Emergency_Contact - Step 02: Input value of fields");
		myInfoPage.inputToTextBoxByID(driver, "emgcontacts_name", emerContactName);
		myInfoPage.inputToTextBoxByID(driver, "emgcontacts_relationship", emerRelationship);
		myInfoPage.inputToTextBoxByID(driver, "emgcontacts_homePhone", emerTelephone);
		myInfoPage.inputToTextBoxByID(driver, "emgcontacts_mobilePhone", emerMobile);

		log.info("05_Emergency_Contact - Step 05: Click to 'Save' button at 'Contact Details'");
		myInfoPage.clickToButtonByID(driver, "btnSaveEContact");

		log.info("05_Emergency_Contact - Step 06: Verify success message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Saved"));

		log.info("05_Emergency_Contact - Step 05: Verify all value at Emer list table");
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "emgcontact_list", "Name", "1"), emerContactName);
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "emgcontact_list", "Relationship", "1"), emerRelationship);
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "emgcontact_list", "Home Telephone", "1"), emerTelephone);
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "emgcontact_list", "Mobile", "1"), emerMobile);

	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		log.info("06_Assigned_Dependents - Step 01: Open 'Dependents' at Sidebar'");
		myInfoPage.openItemsAtSidebarByName("Dependents");

		log.info("06_Assigned_Dependents - Step 02: Click to 'Add' button ");
		myInfoPage.clickToButtonByID(driver, "btnAddDependent");

		log.info("06_Assigned_Dependents - Step 02: Input value to fields");
		myInfoPage.inputToTextBoxByID(driver, "dependent_name", depenName);
		myInfoPage.selectItemDropdownByID(driver, "dependent_relationshipType", depenRelationship);
		myInfoPage.inputToTextBoxByID(driver, "dependent_dateOfBirth", depenDOB);

		log.info("06_Assigned_Dependents - Step 02: Click to 'Save' button ");
		myInfoPage.clickToButtonByID(driver, "btnSaveDependent");

		log.info("06_Assigned_Dependents - Step 06: Verify success message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Saved"));

		log.info("06_Assigned_Dependents - Step 02: Verify value of fields after added");
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "dependent_list", "Name", "1"), depenName);
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "dependent_list", "Relationship", "1"), "child");
		verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "dependent_list", "Date of Birth", "1"), depenDOB);
	}

	@Test
	public void Employee_07_Edit_Job() {
		log.info("07_Edit_Job - Step 01: Login to Admin system");
		loginPage = myInfoPage.logoutToSystem(driver);
		loginPage.loginToSystem("Admin", "admin123");
		dashBoardPage = PageGeneratorManager.getDashboardPage(driver);

		log.info("07_Edit_Job - Step 01: Open 'Employee List' ");
		dashBoardPage.openSubMenuHeader(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		
		log.info("07_Edit_Job - Step 13: Input valid info to 'Employee Name' textbox ");
		employeeListPage.SleepInSecond(3);
		employeeListPage.inputToTextBoxByIDs(driver, "empsearch_employee_name_empName", editFullName);
		employeeListPage.SleepInSecond(3);

		log.info("07_Edit_Job - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		employeeListPage.SleepInSecond(3);
		
		log.info("07_Edit_Job - Step 14: Click to user found");
		employeeListPage.clickToItemValueOfTableAtColumnAndRowIndex(driver, "resultTable", "Id", "1");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);
		
		log.info("07_Edit_Job - Step 01: Open 'Job' at Sidebar'");
		myInfoPage.openItemsAtSidebarByName("Job");
	}

	@Test
	public void Employee_08_Edit_Salary() {

	}

	@Test
	public void Employee_09_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {
		log.info("10_Qualifications - Step 01: Login to User system");
		loginPage = myInfoPage.logoutToSystem(driver);
		loginPage.loginToSystem(empUserName, empPassword);
		dashBoardPage = PageGeneratorManager.getDashboardPage(driver);
		
		log.info("10_Qualifications - Step 02: Open 'My Info' at Header");
		dashBoardPage.openMenuHeader(driver, "My Info");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);
		
		log.info("10_Qualifications - Step 01: Open 'Qualifications' at Sidebar");
		myInfoPage.openItemsAtSidebarByName("Qualifications");
		
		log.info("10_Qualifications - Step 01: Click to 'Add' button at 'Add Work Experience'");
		myInfoPage.clickToButtonByID(driver, "addWorkExperience");
		
		log.info("10_Qualifications - Step 01: Input value of fields at 'Add Work Experience'");
		myInfoPage.inputToTextBoxByIDs(driver, "experience_employer", empCompany);
		myInfoPage.inputToTextBoxByIDs(driver, "experience_jobtitle", empJobTitle);
		myInfoPage.inputToTextBoxByIDs(driver, "experience_from_date", empFrom);
		myInfoPage.inputToTextBoxByIDs(driver, "experience_to_date", empTo);
		
		log.info("10_Qualifications - Step 02: Click to 'Save' button ");
		myInfoPage.clickToButtonByID(driver, "btnWorkExpSave");

		log.info("10_Qualifications - Step 06: Verify success message displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayedByName(driver, "Successfully Saved"));

		log.info("10_Qualifications - Step 02: Verify value of fields after added");
		//verifyEquals(myInfoPage.getValueOfTableAtColumnAndRowIndex(driver, "dependent_list", "Name", "1"), depenName);
	}

	@Test
	public void Employee_11_Search() {

	}

	
	@AfterClass
	public void quiteBrowser() {
		driver.quit();
	}

}
