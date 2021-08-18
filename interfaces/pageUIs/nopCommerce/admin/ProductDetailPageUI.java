package pageUIs.nopCommerce.admin;

public class ProductDetailPageUI {
	public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and string()='%s']/following-sibling::div//i";
//	public static final String UPLOAD_FILE_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
	public static final String UPLOAD_PICTURE_BLOCK_FILE_NAME = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']/preceding-sibling::input";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String PICTURE_DISPLAY_ORDER_ALT_TITLE = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[text()='%s']//following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String DETETE_PICTURE_BY_TITLE = "//td[text()='%s']/following-sibling::td/a[contains(string(),'%s')]";
	
		
}
