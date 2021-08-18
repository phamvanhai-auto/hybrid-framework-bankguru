package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.ProductSearchPageUI;

public class ProductSearchPO extends BasePage{
	WebDriver driver;
	
	public ProductSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchProduct(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.SEARCH_PRODUCT_TEXTBOX);
		sendKeyToElement(driver, ProductSearchPageUI.SEARCH_PRODUCT_TEXTBOX, productName);
	}

	public void clickSearchButton() {
		waitForElementVisible(driver, ProductSearchPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_PRODUCT_BUTTON);
	}

	public ProductDetailPO clickEditButtonByProductName(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.EDIT_BY_PRODUCT_NAME_BUTTON, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BY_PRODUCT_NAME_BUTTON, productName);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isSucessMessageDisplayed(String successMessageName) {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_UPDATED_MESSAGE, successMessageName);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_UPDATED_MESSAGE, successMessageName);
	}

	public boolean isPictureAndProductNameDisplayed(String pictureName, String productName) {
		pictureName = pictureName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PICTURE_AND_PRODUCT_NAME, pictureName, productName);
		return isElementDisplayed(driver, ProductSearchPageUI.PICTURE_AND_PRODUCT_NAME, pictureName, productName);
	}

}
