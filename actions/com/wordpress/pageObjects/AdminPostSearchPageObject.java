package com.wordpress.pageObjects;

import org.openqa.selenium.WebDriver;

import com.wordpress.pageUIs.AdminPostSearchPageUI;

import common.BasePage;

public class AdminPostSearchPageObject extends BasePage{
	WebDriver driver;

	public AdminPostSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPageObject clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getPostAddNewPage(driver);
		
	}

	public void inputToSearchPostTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX, postTitle);
		
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		
	}

	public boolean isPostSearchTableDisplayed(String headerID, String tableRowValue) {
		int index = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(index),tableRowValue);
		return elementIsDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(index),tableRowValue);
			
	}

	public AdminPostAddNewPageObject clickToPostTitle(String tableRowValue) {
		//int index = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementClickable(driver, AdminPostSearchPageUI.TITLE_VALUE_IN_ROW,tableRowValue);
		//waitForElementVisible(driver, AdminPostSearchPageUI.TITLE_VALUE_IN_ROW,String.valueOf(index), tableRowValue);
		clickToElement(driver, AdminPostSearchPageUI.TITLE_VALUE_IN_ROW,tableRowValue);
		return PageGeneratorManager.getPostAddNewPage(driver);
	}



	
}
