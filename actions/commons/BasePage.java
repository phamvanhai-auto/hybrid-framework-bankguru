package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.LoginPO;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MyAccountFooterPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.ShippingAndReturnPageObject;
import pageObjects.nopCommerce.SiteMapPageObject;
import pageObjects.nopCommerce.WishListHeaderPageObject;
import pageUIs.hrm.BasePageUIs;
import pageUIs.hrm.MyInfoUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.admin.AdminBasePageUIs;

public class BasePage {

	private Alert alert;
	private Select select;
	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private long short_timeout = GlobalConstants.SHORT_TIMEOUT;
	private long long_timeout = GlobalConstants.LONG_TIMEOUT;

	// WebBrowsers
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
		SleepInSecond(2);
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	public void switchToWindowbyID(WebDriver driver, String parentID) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void switchToWindowTitle(WebDriver driver, String titleWindow) {
		Set<String> allTabsID = driver.getWindowHandles();
		for (String id : allTabsID) {
			driver.switchTo().window(id);
			String getTitle = driver.getTitle();
			if (getTitle.equals(titleWindow))
				break;
		}
	}

	public void closeWindowExceptParent(WebDriver driver, String parentWindow) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			if (!id.equals(parentWindow)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void SleepInSecond(long timeoutSecond) {
		try {
			Thread.sleep(timeoutSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// WebElement
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	// getDynamic Locators
	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int getElementSize(WebDriver driver, String locator, String... params) {
		return getElements(driver, getDynamicLocator(locator, params)).size();
	}

	public void selectItemInDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public void selectItemInDropdownByText(WebDriver driver, String locator, String itemText, String... params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMutiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCusDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedOption) {
		getElement(driver, parentXpath).click();

		explicitWait = new WebDriverWait(driver, long_timeout);
		List<WebElement> allOption = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

		for (WebElement option : allOption) {
			if (option.getText().trim().equals(expectedOption)) {
				jsExecutor = (JavascriptExecutor) driver;
				if (!option.isDisplayed()) {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
					SleepInSecond(1);
				}
				option.click();
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText().trim();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void uncheckToCheckboxOrRadio(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			return false;
			// e.printStackTrace();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		try {
			return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {

		overrideGlobalTimeout(driver, short_timeout);
		List<WebElement> elements = getElements(driver, locator);
		overrideGlobalTimeout(driver, long_timeout);

		if (elements.size() == 0)
			return true;
		else if (elements.size() > 0 && !elements.get(0).isDisplayed())
			return true;
		else
			return false;
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isSelected();
	}

	public WebDriver switchToIFrameByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void hoverToElement(WebDriver driver, String locator, String... params) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
		;
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		locator = getDynamicLocator(locator, params);
		action.sendKeys(getElement(driver, locator), key).perform();
		;
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean isJQueryAndAjaxloadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, long_timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, short_timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	// define Pages (User - Nop commerce)
	public SearchPageObject openSearchPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.SEARCH_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.SEARCH_PAGE_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public ShippingAndReturnPageObject openShippingAndReturnPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.SHIPPING_RETURN_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.SHIPPING_RETURN_PAGE_FOOTER);
		return PageGeneratorManager.getShippingAndReturnPage(driver);

	}

	public SiteMapPageObject openSiteMapPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.SITE_MAP_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.SITE_MAP_PAGE_FOOTER);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	public MyAccountFooterPageObject openMyAccountFooterPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		return PageGeneratorManager.getMyAccountFooterPage(driver);
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.HOME_PAGE);
		clickToElement(driver, BasePageUI.HOME_PAGE);
		return PageGeneratorManager.getHomePage(driver);
	}

	public WishListHeaderPageObject openWishListHeader(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.WISHLIST_PAGE_HEADER);
		clickToElement(driver, BasePageUI.WISHLIST_PAGE_HEADER);
		return PageGeneratorManager.getWishListHeaderPage(driver);
	}

	// chỉ cần 1 hàm cho Pages (switch page)
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOCATOR_FOOTER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_LOCATOR_FOOTER, pageName);
	}

	public void openHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOCATOR_HEADER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_LOCATOR_HEADER, pageName);
	}

	// Admin - NopCommerce
	public void openSubMenuByName(WebDriver driver, String menuName, String subMenuName) {
		waitForElementVisible(driver, AdminBasePageUIs.MENU_LINK_BY_NAME, menuName);
		clickToElement(driver, AdminBasePageUIs.MENU_LINK_BY_NAME, menuName);

		waitForElementVisible(driver, AdminBasePageUIs.SUB_MENU_LINK_BY_NAME, subMenuName);
		clickToElement(driver, AdminBasePageUIs.SUB_MENU_LINK_BY_NAME, subMenuName);
	}

	public void uploadFilesByCardName(WebDriver driver, String cardName, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, AdminBasePageUIs.UPLOAD_FILE_CARD_NAME, cardName).sendKeys(fullFileName);

	}

	// Pattern Object
	public void openHeaderPageByLinkName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOCATOR_HEADER_LINK_NAME, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_LOCATOR_HEADER_LINK_NAME, pageName);
	}

	public void clickToRadioButtonByName(WebDriver driver, String radioName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LOCATOR_RADIO_BUTTON_BY_NAME, radioName);
		clickToElement(driver, BasePageUI.DYNAMIC_LOCATOR_RADIO_BUTTON_BY_NAME, radioName);
	}

	public void inputToTextBoxByID(WebDriver driver, String textBoxID, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOCATOR_TEXT_BOX_BY_ID, textBoxID);
		sendKeyToElement(driver, BasePageUI.DYNAMIC_LOCATOR_TEXT_BOX_BY_ID, value, textBoxID);
	}

	public void clickToButtonByName(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LOCATOR_BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.DYNAMIC_LOCATOR_BUTTON_BY_NAME, buttonName);
	}

	public void selectDropdownByName(WebDriver driver, String dropDownName, String itemText) {
		selectItemInDropdownByText(driver, BasePageUI.DYNAMIC_LOCATOR_DROPDOWN_BY_NAME, itemText, dropDownName);
	}

	// Orange HRM
	// Menu header
	public void openMenuHeader(WebDriver driver, String menuHeader) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);
		clickToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);

	}

	// SubMenu header
	public void openSubMenuHeader(WebDriver driver, String menuHeader, String subMenuHeader) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);
		clickToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);

		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, subMenuHeader);
		clickToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, subMenuHeader);

	}

	// ChildSubMenu header
	public void openChildSubMenuHeader(WebDriver driver, String menuHeader, String subMenuHeader, String childSubMenuHeader) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);
		clickToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, menuHeader);

		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, subMenuHeader);
		hoverToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, subMenuHeader);

		waitForElementVisible(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, childSubMenuHeader);
		clickToElement(driver, BasePageUIs.DYNAMIC_MENU_HEADER_BY_NAME, childSubMenuHeader);
	}

	public void clickToButtonByID(WebDriver driver, String buttonID) {
		waitForElementClickable(driver, BasePageUIs.DYNAMIC_BUTTON_BY_ID, buttonID);
		clickToElement(driver, BasePageUIs.DYNAMIC_BUTTON_BY_ID, buttonID);
	}

	public void inputToTextBoxByIDs(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(driver, BasePageUIs.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	// get Value of Textbox
	public String getValueOfTextBoxByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageUIs.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	// click to checkbox/radio
	public void clickToCheckboxByLabelName(WebDriver driver, String labelName) {
		waitForElementClickable(driver, BasePageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
		checkToCheckboxOrRadio(driver, BasePageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
	}

	// select dropdown
	public void selectItemDropdownByID(WebDriver driver, String dropdownID, String itemName) {
		waitForElementClickable(driver, BasePageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDropdownByText(driver, BasePageUIs.DYNAMIC_DROPDOWN_BY_ID, itemName, dropdownID);
	}

	// get selected item in dropdown
	public String getSelectedItemDropdownByID(WebDriver driver, String dropdownID) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemDropdown(driver, BasePageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}

	public String getValueOfTableAtColumnAndRowIndex(WebDriver driver, String tableName, String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUIs.DYNAMIC_COLUMN_INDEX_BY_TABLE_AND_COLUMN_NAME, tableName, columnName) + 1;

		waitForElementVisible(driver, BasePageUIs.DYNAMIC_ROW_INDEX_BY_TABLE_NAME_AND_ROW_COLUMN, tableName, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, BasePageUIs.DYNAMIC_ROW_INDEX_BY_TABLE_NAME_AND_ROW_COLUMN, tableName, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToItemValueOfTableAtColumnAndRowIndex(WebDriver driver, String tableName, String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUIs.DYNAMIC_COLUMN_INDEX_BY_TABLE_AND_COLUMN_NAME, tableName, columnName) + 1;

		waitForElementVisible(driver, BasePageUIs.DYNAMIC_ROW_INDEX_BY_TABLE_NAME_AND_ROW_COLUMN, tableName, rowIndex, String.valueOf(columnIndex));
		clickToElement(driver, BasePageUIs.DYNAMIC_ROW_INDEX_BY_TABLE_NAME_AND_ROW_COLUMN, tableName, rowIndex, String.valueOf(columnIndex));
	}

	public LoginPO logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageUIs.WELCOME_USER);
		clickToElement(driver, BasePageUIs.WELCOME_USER);

		waitForElementClickable(driver, BasePageUIs.LOGOUT_LINK);
		clickToElement(driver, BasePageUIs.LOGOUT_LINK);

		return pageObjects.hrm.PageGeneratorManager.getLoginPage(driver);
	}

	public void upLoadImage(WebDriver driver, String filePath) {
		getElement(driver, BasePageUIs.UPLOAD_FILE).sendKeys(filePath);
	}

	public boolean isFieldEnabledByID(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, BasePageUIs.ANY_FIELD_BY_ID, fieldID);
		return isElementEnabled(driver, BasePageUIs.ANY_FIELD_BY_ID, fieldID);
	}

	public boolean isMessageSuccessDisplayedByName(WebDriver driver, String messageName) {
		waitForElementVisible(driver, BasePageUIs.SUCCESS_MESSAGE, messageName);
		return isElementDisplayed(driver, BasePageUIs.SUCCESS_MESSAGE, messageName);
	}

	public boolean isRaidoSelectedByLabel(WebDriver driver, String labelName) {
		waitForElementVisible(driver, BasePageUIs.RADIO_BY_LABEL, labelName);
		return isElementSelected(driver, BasePageUIs.RADIO_BY_LABEL, labelName);
	}
	
	public boolean isCheckboxCheckedByLabel(WebDriver driver, String labelName) {
		waitForElementVisible(driver, BasePageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
		return isElementSelected(driver, BasePageUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME, labelName);
	}
}
