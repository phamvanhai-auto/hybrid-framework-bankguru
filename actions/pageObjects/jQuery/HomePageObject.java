package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);	
	}

	public boolean isPageOpenedByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_OPENED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_OPENED_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderBoxByColumnName(String columnName, String value) {
		waitForElementVisible(driver, HomePageUI.INPUT_HEADER_COLUMN_NAME, columnName);
		sendKeyToElement(driver, HomePageUI.INPUT_HEADER_COLUMN_NAME, value, columnName);
		pressKeyToElement(driver, HomePageUI.INPUT_HEADER_COLUMN_NAME, Keys.ENTER, columnName);
	}

	public void clickToIconByCountryName(String countryName, String action) {
		waitForElementVisible(driver, HomePageUI.REMOVE_OR_DELETE_ROW, countryName, action);
		clickToElement(driver, HomePageUI.REMOVE_OR_DELETE_ROW, countryName, action);
	}

	public boolean isRowValueCorrect(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, females, country, males, total);
	}

	public void inputToRowBoxByIndex(String columnName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.INPUT_COLUMN_INDEX, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_COL_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_COL_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToButtonByRowNumber(String rowIndex, String actions) {
		waitForElementVisible(driver, HomePageUI.BUTTON_ROW_INDEX, rowIndex, actions);
		clickToElement(driver, HomePageUI.BUTTON_ROW_INDEX, rowIndex, actions);
	}

}
