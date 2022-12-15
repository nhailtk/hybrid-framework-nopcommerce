package saucedemo.com.pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import saucedemo.com.pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMenuButton() {
		waitForElementVisible(driver, HomePageUI.MENU_BUTTON);
		return elementIsDisplayed(driver, HomePageUI.MENU_BUTTON);
	}

	public void clickToSortDropdown(String textItem) {
		waitForElementClickable(driver, HomePageUI.SORT_DROPDOWN);
		selectItemByTextInDefaultDropdown(driver, HomePageUI.SORT_DROPDOWN, textItem);
	}

	public boolean isDisplayedSortWithNameASC() {
		ArrayList<String> arrayName = new ArrayList<>();
		
		List<WebElement> elementList = getListWebElement(driver, HomePageUI.ITEM_NAME_LIST);
		
		for(WebElement element:elementList) {
			arrayName.add(element.getText());
		}
		
		ArrayList<String> sortArrayName = new ArrayList<>();
		for(String name: arrayName) {
			sortArrayName.add(name);
		}
		
		Collections.sort(sortArrayName);
		
		return sortArrayName.equals(arrayName);
		
	}

	public boolean isDisplayedSortWithNameDESC() {
		ArrayList<String> arrayName = new ArrayList<>();
		
		List<WebElement> elementList = getListWebElement(driver, HomePageUI.ITEM_NAME_LIST);
		
		for(WebElement element:elementList) {
			arrayName.add(element.getText());
		}
		
		ArrayList<String> sortArrayName = new ArrayList<>();
		for(String name: arrayName) {
			sortArrayName.add(name);
		}
		
		Collections.sort(sortArrayName);
		
		Collections.reverse(sortArrayName);
		
		return sortArrayName.equals(arrayName);
	}

	public boolean isDisplayedSortWithPriceASC() {
		ArrayList<Float> arrayPrice = new ArrayList<Float>();
		
		List<WebElement> elementList = getListWebElement(driver, HomePageUI.ITEM_PRICE_LIST);
		
		for(WebElement element:elementList) {
			arrayPrice.add(Float.parseFloat(element.getText().replace("$", "")));
		}
		
		ArrayList<Float> sortArrayPrice = new ArrayList<Float>();
		
		for(Float price: arrayPrice) {
			sortArrayPrice.add(price);
		}
		
		Collections.sort(sortArrayPrice);
	
		
		return sortArrayPrice.equals(arrayPrice);
	}

	public boolean isDisplayedSortWithPriceDESC() {
		ArrayList<Float> arrayPrice = new ArrayList<Float>();
		
		List<WebElement> elementList = getListWebElement(driver, HomePageUI.ITEM_PRICE_LIST);
		
		for(WebElement element:elementList) {
			arrayPrice.add(Float.parseFloat(element.getText().replace("$", "")));
		}
		
		ArrayList<Float> sortArrayPrice = new ArrayList<Float>();
		for(Float price: arrayPrice) {
			sortArrayPrice.add(price);
		}
		
		Collections.sort(sortArrayPrice);
	 
		Collections.reverse(sortArrayPrice);
		
		return sortArrayPrice.equals(arrayPrice);
	}

	
}
