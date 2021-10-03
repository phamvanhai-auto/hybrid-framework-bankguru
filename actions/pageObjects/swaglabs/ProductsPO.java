package pageObjects.swaglabs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.hrm.LoginUI;
import pageUIs.swaglabs.ProductsUI;

public class ProductsPO extends BasePage{
	private WebDriver driver;
	
	public ProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String sortName) {
		waitForElementVisible(driver, ProductsUI.SORT_DROPDOWN);
		selectItemInDropdownByText(driver, ProductsUI.SORT_DROPDOWN, sortName);
		
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productNames = getElements(driver, ProductsUI.PRODUCT_NAME);
		
		List<String> productNameList = new ArrayList<>();
		
		for (WebElement productName : productNames) {
			productNameList.add(productName.getText());
		}
		
		System.out.println("Before Ascending==================================");
		for (String name : productNameList) {
			System.out.println(name);
		}
		
		List<String> productNameListClone = new ArrayList<>(productNameList);
		Collections.sort(productNameListClone);
		
		System.out.println("After Ascending===================================");
		for (String name : productNameList) {
			System.out.println(name);
		}
		
		return productNameList.equals(productNameListClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNames = getElements(driver, ProductsUI.PRODUCT_NAME);
		
		List<String> productNameList = new ArrayList<>();
		
		for (WebElement productName : productNames) {
			productNameList.add(productName.getText());
		}
		
		System.out.println("Before Descending===============================");
		for (String name : productNameList) {
			System.out.println(name);
		}
		
		List<String> productNameListClone = new ArrayList<>(productNameList);
		Collections.sort(productNameListClone);
		Collections.reverse(productNameListClone);
		
		System.out.println("After Descending================================");
		for (String name : productNameList) {
			System.out.println(name);
		}
		
		return productNameList.equals(productNameListClone);
	}

	public boolean isProductPriceSortAscending() {
		List<WebElement> productNames = getElements(driver, ProductsUI.PRODUCT_PRICE);
		
		List<Float> productPriceList = new ArrayList<>();
		
		for (WebElement productName : productNames) {
			Float productPriceNumber = Float.parseFloat(productName.getText().replace("$",""));
			productPriceList.add(productPriceNumber);
		}
		
		System.out.println("Before Ascending==================================");
		for (Float name : productPriceList) {
			System.out.println(name);
		}
		
		List<Float> productPriceListClone = new ArrayList<>(productPriceList);
		Collections.sort(productPriceListClone);
		
		System.out.println("After Ascending===================================");
		for (Float name : productPriceListClone) {
			System.out.println(name);
		}
		
		return productPriceList.equals(productPriceListClone);
	}

	public boolean isProductPriceSortDesending() {
		List<WebElement> productNames = getElements(driver, ProductsUI.PRODUCT_PRICE);
		
		List<Float> productPriceList = new ArrayList<>();
		
		for (WebElement productName : productNames) {
			Float productPriceNumber = Float.parseFloat(productName.getText().replace("$",""));
			productPriceList.add(productPriceNumber);
		}
		
		System.out.println("Before Ascending==================================");
		for (Float name : productPriceList) {
			System.out.println(name);
		}
		
		List<Float> productPriceListClone = new ArrayList<>(productPriceList);
		Collections.sort(productPriceListClone);
		Collections.reverse(productPriceListClone);
		
		System.out.println("After Ascending===================================");
		for (Float name : productPriceListClone) {
			System.out.println(name);
		}
		
		return productPriceList.equals(productPriceListClone);
	}

}
