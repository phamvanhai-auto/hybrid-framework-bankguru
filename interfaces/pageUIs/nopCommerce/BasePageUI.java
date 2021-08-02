package pageUIs.nopCommerce;

public class BasePageUI {
	public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
	public static final String SHIPPING_RETURN_PAGE_FOOTER = "//div[@class='footer']//a[text()='Shipping & returns']";
	public static final String SITE_MAP_PAGE_FOOTER = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	public static final String HOME_PAGE = "//img[@alt='nopCommerce demo store']";
	public static final String WISHLIST_PAGE_HEADER = "//a[@class='ico-wishlist']";  

	//1 locator dynamic for all above locators
	public static final String DYNAMIC_LOCATOR_FOOTER = "//div[@class='footer']//a[text()='%s']";
	
	public static final String DYNAMIC_LOCATOR_HEADER = "//div[@class='header']//span[text()='%s']";
}
