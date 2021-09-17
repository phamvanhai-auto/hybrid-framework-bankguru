package pageUIs.hrm;

public class BasePageUIs {
	public static final String DYNAMIC_MENU_HEADER_BY_NAME = "//div[@id='mainMenu']//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "//label[text()='%s']/following-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String DYNAMIC_COLUMN_INDEX_BY_TABLE_AND_COLUMN_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_ROW_INDEX_BY_TABLE_NAME_AND_ROW_COLUMN = "//table[@id='%s']//tbody/tr[%s]//td[%s]";
	public static final String DYNAMIC_ITEM_VALUE_IN_ROW = "//table[@id='%s']//tbody/tr[%s]//td[string()='%s']";
	public static final String WELCOME_USER = "//a[@id='welcome']";
	public static final String LOGOUT_LINK = "//a[text()='Logout']";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	
	public static final String ANY_FIELD_BY_ID = "//*[@id='%s']";
	public static final String SUCCESS_MESSAGE = "//div[@class='inner']/div[contains(text(),'%s')]";
	public static final String RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
}
