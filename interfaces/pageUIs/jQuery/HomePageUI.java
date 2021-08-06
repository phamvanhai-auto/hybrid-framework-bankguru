package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_OPENED_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String INPUT_HEADER_COLUMN_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String REMOVE_OR_DELETE_ROW = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String INPUT_COLUMN_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_COL_ROW_INDEX = "//tr[%s]/td[%s]/input";
	public static final String BUTTON_ROW_INDEX = "//tr[@id][%s]//p/button[@title='%s']";

}
