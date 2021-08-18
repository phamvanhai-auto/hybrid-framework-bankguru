package pageUIs.nopCommerce.admin;

public class ProductSearchPageUI {
	public static final String SEARCH_PRODUCT_TEXTBOX = "//div/input[@id='SearchProductName']";
	public static final String SEARCH_PRODUCT_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BY_PRODUCT_NAME_BUTTON = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Edit')]";
	public static final String SUCCESS_UPDATED_MESSAGE = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String PICTURE_AND_PRODUCT_NAME = "//img[contains(@src,'%s')]/parent::td/following-sibling::td[text()='%s']";
	
}
