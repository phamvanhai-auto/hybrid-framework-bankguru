package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPO loginPage;
	private static DashboardPO dashBoardPage;
	private static ProductSearchPO productSearchPage;
	private static ProductDetailPO productDetailPage;
	
	
	private PageGeneratorManager() {
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPO(driver);
		}
		return loginPage;
	}
	
	public static DashboardPO getDashboardPage(WebDriver driver) {
		if(dashBoardPage == null) {
			dashBoardPage = new DashboardPO(driver);
		}
		return dashBoardPage;
	}
	
	public static ProductSearchPO getProductSearchPage(WebDriver driver) {
		if(productSearchPage == null) {
			productSearchPage = new ProductSearchPO(driver);
		}
		return productSearchPage;
	}
	 	
	public static ProductDetailPO getProductDetailPage(WebDriver driver) {
		if(productDetailPage == null) {
			productDetailPage = new ProductDetailPO(driver);
		}
		return productDetailPage;
	}
}
