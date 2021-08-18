package pageUIs.nopCommerce.admin;

public class AdminBasePageUIs {
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(string(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME = "//ul[@style]//a//p[contains(string(),'%s')]";

	public static final String UPLOAD_FILE_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
}
