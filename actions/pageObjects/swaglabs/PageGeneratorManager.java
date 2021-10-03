package pageObjects.swaglabs;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static ProductsPO getProductsPage(WebDriver driver) {
		return new ProductsPO(driver);
	}
	
}
