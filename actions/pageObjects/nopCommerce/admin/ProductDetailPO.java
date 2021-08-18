package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.ProductDetailPageUI;

public class ProductDetailPO extends BasePage{
	WebDriver driver;
	
	public ProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toogleIconStatus.contains("fa-plus")) {
			waitForElementVisible(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}

	public boolean isPictureUploadDisplayedByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUI.UPLOAD_PICTURE_BLOCK_FILE_NAME, fileName);
		return isElementDisplayed(driver, ProductDetailPageUI.UPLOAD_PICTURE_BLOCK_FILE_NAME, fileName);
	}

	public void inputToAltBox(String altName) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX, altName);
	}

	public void inputToTitleBox(String titleName) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX, titleName);
	}

	public void inputToDisplayOrderBox(String orderNumber) {
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX, orderNumber);
	}

	public void clickToAddProductPictureButton() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureAndValueUpdated(String pictureName, String displayOrder, String altName, String titleName) {
		pictureName = pictureName.replace(" ", "-").toLowerCase();
		
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_DISPLAY_ORDER_ALT_TITLE, pictureName, displayOrder, altName, titleName);
		return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_DISPLAY_ORDER_ALT_TITLE, pictureName, displayOrder, altName, titleName);
	}

	public ProductSearchPO clickToSaveButton() {
		waitForElementVisible(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonByPictureName(String titleText, String deleteButton) {
		waitForElementVisible(driver, ProductDetailPageUI.DETETE_PICTURE_BY_TITLE, titleText, deleteButton);
		clickToElement(driver, ProductDetailPageUI.DETETE_PICTURE_BY_TITLE, titleText, deleteButton);
		SleepInSecond(2);
		acceptAlert(driver);
	}
}
