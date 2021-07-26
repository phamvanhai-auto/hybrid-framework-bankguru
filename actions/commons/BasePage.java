package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private Alert alert;
	private Select select;
	private Actions action;
	private long timeout = 15;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;

	//WebBrowsers
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

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
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

	//WebElement
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void selectItemInDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMutiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCusDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedOption) {
		getElement(driver, parentXpath).click(); 
		
		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allOption = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		
		for (WebElement option : allOption) {
			if (option.getText().trim().equals(expectedOption)) {
				jsExecutor = (JavascriptExecutor) driver;
				if(!option.isDisplayed()) {
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
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if(!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public void uncheckToCheckboxOrRadio(WebDriver driver, String locator) {
		if(isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
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
		action.sendKeys(getElement(driver, locator), key);
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

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
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
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
}
