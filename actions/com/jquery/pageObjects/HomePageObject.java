package com.jquery.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jquery.pageUIs.HomePageUI;

import common.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isDisplayPageActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return elementIsEnabled(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputDataToHeaderByLabel(String headerLabel, String valueToHeaderTextbox) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, valueToHeaderTextbox, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public List<String> getEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGE);
		List<String> allRowValuesAllPage = new ArrayList<String>();
		// duyet qua tat cac cac page
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, String.valueOf(i));
			//duyet tat ca cac element tren 1 page
			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_IN_EACH_PAGE);
			for (WebElement eachElement : allRowEachPage) {
				allRowValuesAllPage.add(eachElement.getText());
			}
		}
		for (String value : allRowValuesAllPage) {
			System.out.println(value);
		}
		return allRowValuesAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, value, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		selectItemByTextInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_NUMBER, value, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		checktoDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));

	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		unchecktoDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToRemoveButtonByRowNumber(String rowNumber, String textButton) {
		waitForElementClickable(driver, HomePageUI.BUTTON_BY_ROW_NUMBER, rowNumber, textButton );
		clickToElement(driver,HomePageUI.BUTTON_BY_ROW_NUMBER, rowNumber, textButton );
	}

}
